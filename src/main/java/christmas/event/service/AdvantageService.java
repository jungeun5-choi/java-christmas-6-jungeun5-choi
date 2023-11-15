package christmas.event.service;

import christmas.common.enumerator.EventType;
import christmas.common.enumerator.MenuType;
import christmas.event.model.EventData;
import christmas.event.repository.AdvantageRepository;
import christmas.event.repository.EventRepository;
import christmas.menu.model.MenuData;
import christmas.menu.repository.MenuRepository;
import christmas.order.repository.OrderRepository;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AdvantageService {
    private static final int AMOUNT_INCREASE = 100;
    private static final int AMOUNT_REQUIRED_FOR_ADVANTAGE = 10000;

    private final EventRepository eventRepository;
    private final OrderRepository orderRepository;
    private final AdvantageRepository advantageRepository;

    public AdvantageService(EventRepository eventRepository, OrderRepository orderRepository,
                            AdvantageRepository advantageRepository) {
        this.eventRepository = eventRepository;
        this.orderRepository = orderRepository;
        this.advantageRepository = advantageRepository;
    }

    /*
     * process
     * 1. 크리스마스 디데이 할인
     * 2. 평일 할인
     * 3. 주말 할인
     * 4. 특별 할인
     * 5. 증정 이벤트
     */
    public void process() {
        if (!isSatisfiedRequireAmount()) {
            return;
        }

        for (EventType type : EventType.values()) {
            verifyAdvantage(type);
        }
    }

    private boolean isSatisfiedRequireAmount() {
        return OrderRepository.findTotalAmount() >= AMOUNT_REQUIRED_FOR_ADVANTAGE;
    }

    private void verifyAdvantage(EventType type) {
        if (type.isSatisfied()) {
            saveAdvantage(type);
        }
    }

    private void saveAdvantage(EventType type) {
        EventData event = findEvent(type);
        int discount = calculateDiscount(type);
        advantageRepository.save(event, discount);
    }

    private int calculateDiscount(EventType type) {
        int discount = eventRepository.findDefaultDiscountByEventType(type);
        if (Objects.equals(type, EventType.CHRISTMAS_D_DAY)) {
            return discountIncreaseByDDay(discount);
        }
        if (Objects.equals(type, EventType.WEEKDAY)) {
            return discountByMenuType(discount, MenuType.Dessert);
        }
        if (Objects.equals(type, EventType.WEEKEND)) {
            return discountByMenuType(discount, MenuType.Main);
        }
        return discount;
    }

    private int discountIncreaseByDDay(int discount) {
        int visitDay = OrderRepository.findVisitDay() - 1;
        return discount + (AMOUNT_INCREASE * visitDay);
    }

    private int discountByMenuType(int discount, MenuType type) {
        for (String name : orderRepository.findOrderMenuName()) {
            MenuData menuData = MenuRepository.findMenuByName(name);
            if (Objects.equals(menuData.type(), type)) {
                discount += discount;
            }
        }
        return discount;
    }

    private EventData findEvent(EventType type) {
        return EventRepository.findEventByEventType(type);
    }


    /* present */

    public boolean hasAdvantage(EventType type) {
        return Objects.nonNull(advantageRepository.findAdvantageByEventType(type));
    }

    public boolean hasAdvantages() {
        for (EventType eventType : EventType.values()) {
            return Objects.nonNull(advantageRepository.findAdvantageByEventType(eventType));
        }
        return false;
    }

    public List<EventData> findAllAdvantages() {
        return advantageRepository.findAllAdvantages();
    }

    public Map<EventType, Integer> findAllDiscounts() {
        return advantageRepository.findAllDiscounts();
    }

    public int calculateTotalDiscountAmount() {
        return findAllDiscounts().values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int calculateFinalPayment() {
        int totalOrderAmount = OrderRepository.findTotalAmount();
        int rewardAmount = advantageRepository.findDiscountByEventType(EventType.REWARD);
        int totalDiscount = calculateTotalDiscountAmount() - rewardAmount;
        return totalOrderAmount - totalDiscount;
    }
}
