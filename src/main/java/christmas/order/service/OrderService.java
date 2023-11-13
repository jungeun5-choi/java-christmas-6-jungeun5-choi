package christmas.order.service;

import christmas.common.enumerator.ApplicationState;
import christmas.menu.model.MenuData;
import christmas.menu.repository.MenuRepository;
import christmas.order.dto.OrderDto;
import christmas.order.model.OrderData;
import christmas.order.repository.OrderRepository;
import java.util.Map;

public class OrderService {
    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;

    public OrderService(OrderRepository orderRepository, MenuRepository menuRepository) {
        this.orderRepository = orderRepository;
        this.menuRepository = menuRepository;
    }

    public void save(int visitDay, Map<String, Integer> orders) {
        int totalAmount = calculateTotalAmount(orders);
        orderRepository.save(new OrderData(visitDay, orders, totalAmount));
    }

    public void process() {
        // 주문 처리 로직 구현
        System.out.println(ApplicationState.PROCESS_ORDER);
    }

    public OrderDto present() {
        return convertToDto();
    }

    private int calculateTotalAmount(Map<String, Integer> orders) {
        int total = 0;
        for (String menuName : orders.keySet()) {
            MenuData menuData = menuRepository.findMenuByName(menuName);
            total += menuData.price() * orders.get(menuName);
        }
        return total;
    }

    private OrderDto convertToDto() {
        int visitDay = orderRepository.findOrder().visitDay();
        Map<String, Integer> orders = orderRepository.findOrder().orders();
        int totalAmount = orderRepository.findOrder().totalAmount();
        return new OrderDto(visitDay, orders, totalAmount);
    }
}
