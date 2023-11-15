package christmas.badge.service;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.badge.model.BadgeData;
import christmas.badge.repository.BadgeRepository;
import christmas.common.util.Util;
import christmas.date.repository.DateRepository;
import christmas.date.service.DateService;
import christmas.event.repository.AdvantageRepository;
import christmas.event.repository.EventRepository;
import christmas.event.service.AdvantageService;
import christmas.event.service.EventService;
import christmas.menu.repository.MenuRepository;
import christmas.menu.service.MenuService;
import christmas.order.repository.OrderRepository;
import christmas.order.service.OrderService;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BadgeServiceTest {
    private PrintStream standardOut;
    private OutputStream captor;

    private EventRepository eventRepository;
    private OrderRepository orderRepository;
    private AdvantageRepository advantageRepository;
    private BadgeRepository badgeRepository;
    private AdvantageService advantageService;
    private BadgeService badgeService;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        initialData();
    }

    void initialData() {
        eventRepository = new EventRepository();
        orderRepository = new OrderRepository();
        advantageRepository = new AdvantageRepository();
        badgeRepository = new BadgeRepository();
        advantageService = new AdvantageService(eventRepository, orderRepository, advantageRepository);
        badgeService = new BadgeService(badgeRepository, advantageRepository);

        DateRepository dateRepository = new DateRepository();
        DateService dateService = new DateService(dateRepository);
        EventService eventService = new EventService(eventRepository);
        MenuRepository menuRepository = new MenuRepository();
        MenuService menuService = new MenuService(menuRepository);
        dateService.createDate();
        eventService.createEvent();
        menuService.createMenu();
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());

        badgeRepository.clearAll();
    }

    @Test
    void 뱃지_데이터_생성_테스트() {
        // given
        badgeService.createBadge();

        // when
        for (BadgeData badge : badgeRepository.findAllBadgeData()) {
            System.out.print(badge.type());
            System.out.printf(" / 뱃지 이름: %s", badge.type().getName());
            System.out.printf(" / 뱃지 발급 필요 금액: %s\n", badge.requiredAdvantageAmount());
        }

        // then
        assertThat(output()).contains(
                "STAR", "별", "5000",
                "TREE", "트리", "10000",
                "SANTA", "산타", "20000"
        );
    }

    @Test
    void 뱃지_발급_테스트() {
        // given
        OrderService orderService = new OrderService(orderRepository);
        Map<String, Integer> orders = Util.separateStringWithCommaAndHyphen("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        orderService.save(3, orders);

        badgeService.createBadge();
        advantageService.process();

        // when
        String badgeName = badgeService.issueBadge();

        // then
        assertThat(badgeName).isEqualTo("산타");
    }

    @Test
    void 뱃지_발급조건_미달_테스트() {
        // given
        OrderService orderService = new OrderService(orderRepository);
        Map<String, Integer> orders = Util.separateStringWithCommaAndHyphen("타파스-1,제로콜라-1");
        orderService.save(3, orders);

        badgeService.createBadge();
        advantageService.process();

        // when
        String badgeName = badgeService.issueBadge();

        // then
        assertThat(badgeName).isEqualTo("없음");
    }

    protected final String output() {
        return captor.toString().trim();
    }
}