package christmas.event.service;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.common.enumerator.EventType;
import christmas.common.util.Util;
import christmas.common.view.OutputView;
import christmas.date.repository.DateRepository;
import christmas.date.service.DateService;
import christmas.event.model.EventData;
import christmas.event.repository.AdvantageRepository;
import christmas.event.repository.EventRepository;
import christmas.menu.repository.MenuRepository;
import christmas.menu.service.MenuService;
import christmas.order.repository.OrderRepository;
import christmas.order.service.OrderService;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdvantageServiceTest {
    private PrintStream standardOut;
    private OutputStream captor;

    private EventRepository eventRepository;
    private OrderRepository orderRepository;
    private AdvantageRepository advantageRepository;
    private AdvantageService advantageService;

    @BeforeEach
    void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        initialData();
    }

    void initialData() {
        eventRepository = new EventRepository();
        orderRepository = new OrderRepository();
        advantageRepository = new AdvantageRepository();
        advantageService = new AdvantageService(eventRepository, orderRepository, advantageRepository);

        DateRepository dateRepository = new DateRepository();
        DateService dateService =new DateService(dateRepository);
        EventService eventService = new EventService(eventRepository);
        MenuRepository menuRepository = new MenuRepository();
        MenuService menuService = new MenuService(menuRepository);
        dateService.createDate();
        eventService.createEvent();
        menuService.createMenu();
    }

    @AfterEach
    void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    @Test
    void 이벤트_혜택_적용_테스트() {
        // given
        OrderService orderService = new OrderService(orderRepository);
        Map<String, Integer> orders = Util.separateStringWithCommaAndHyphen("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        orderService.save(3, orders);

        // when
        advantageService.process();

        printRewardList();      /* <증정 메뉴> */
        printAdvantageList();   /* <혜택 내역> */
        printAdvantageAmount(); /* <총혜택 금액> */
        printFinalPayment();    /* <할인 후 예상 결제 금액> */

        // then
        assertThat(output()).contains(
                "<증정 메뉴>",
                "샴페인 1개",
                "<혜택 내역>",
                "크리스마스 디데이 할인: -1,200원",
                "평일 할인: -4,046원",
                "특별 할인: -1,000원",
                "증정 이벤트: -25,000원",
                "<총혜택 금액>",
                "-31,246원",
                "<할인 후 예상 결제 금액>",
                "135,754원"
        );
    }

    @Test
    void 이벤트_참가조건_미달_테스트() {
        // given
        OrderService orderService = new OrderService(orderRepository);
        Map<String, Integer> orders = Util.separateStringWithCommaAndHyphen("타파스-1,제로콜라-1");
        orderService.save(3, orders);

        // when
        advantageService.process();

        printRewardList();      /* <증정 메뉴> */
        printAdvantageList();   /* <혜택 내역> */
        printAdvantageAmount(); /* <총혜택 금액> */
        printFinalPayment();    /* <할인 후 예상 결제 금액> */

        // then
        assertThat(output()).contains(
                "<증정 메뉴>",
                "없음",
                "<혜택 내역>",
                "없음",
                "* 총 주문 금액 10,000원 이상부터 이벤트가 적용됩니다.",
                "<총혜택 금액>",
                "0원",
                "<할인 후 예상 결제 금액>",
                "8,500원"
        );
    }

    private void printRewardList() {
        boolean hasReward = advantageService.hasAdvantage(EventType.REWARD);
        OutputView.getInstance().printReward(hasReward);
    }

    private void printAdvantageList() {
        List<EventData> advantages = advantageService.findAllAdvantages();
        Map<EventType, Integer> discounts = advantageService.findAllDiscounts();
        boolean hasAdvantage = advantageService.hasAdvantages();
        OutputView.getInstance().printAdvantageList(advantages, discounts, hasAdvantage);
    }

    private void printAdvantageAmount() {
        int amount = advantageService.calculateTotalDiscountAmount();
        OutputView.getInstance().printAdvantageAmount(amount);
    }

    private void printFinalPayment() {
        int amount = advantageService.calculateFinalPayment();
        OutputView.getInstance().printFinalPayment(amount);
    }

    String output() {
        return captor.toString().trim();
    }
}