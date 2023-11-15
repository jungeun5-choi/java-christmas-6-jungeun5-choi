package christmas.order.service;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.common.view.OutputView;
import christmas.menu.repository.MenuRepository;
import christmas.menu.service.MenuService;
import christmas.order.dto.OrderDto;
import christmas.order.repository.OrderRepository;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OrderServiceTest extends NsTest {
    @ParameterizedTest
    @MethodSource("orderDataProvider")
    void 주문_데이터_저장_테스트(Integer visitDay, Map<String, Integer> orders) {
        // given
        MenuService menuService = new MenuService(new MenuRepository());
        menuService.createMenu();
        OrderRepository orderRepository = new OrderRepository();
        OrderService orderService = new OrderService(orderRepository);

        // when
        orderService.save(visitDay, orders);
        OrderDto orderDto = orderService.present();
        OutputView.getInstance().printOrderList(orderDto);
        OutputView.getInstance().printTotalOrderAmount(orderDto);

        // then
        assertThat(output()).contains(
                "<주문 메뉴>",
                "티본스테이크 1개",
                "바비큐립 1개",
                "초코케이크 2개",
                "제로콜라 1개",
                "<할인 전 총주문 금액>",
                "142,000원"
        );
    }

    static Stream<Arguments> orderDataProvider() {
        return Stream.of(
                Arguments.of(7, Map.of("티본스테이크", 1, "바비큐립", 1, "초코케이크", 2, "제로콜라", 1))
        );
    }

    @Override
    protected void runMain() {

    }
}