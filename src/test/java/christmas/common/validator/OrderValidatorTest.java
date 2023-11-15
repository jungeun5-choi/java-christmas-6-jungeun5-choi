package christmas.common.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.common.enumerator.ExceptionMessage;
import christmas.date.repository.DateRepository;
import christmas.date.service.DateService;
import christmas.menu.repository.MenuRepository;
import christmas.menu.service.MenuService;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OrderValidatorTest {
    @BeforeEach
    void init() {
        new DateService(new DateRepository()).createDate();
        new MenuService(new MenuRepository()).createMenu();
    }

    @ParameterizedTest
    @MethodSource("visitDayProvider")
    void 방문_날짜_범위_테스트(Integer visitDay, Map<String, Integer> orders) {
        assertThatThrownBy(() -> new OrderValidator().validate(visitDay, orders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_DAY_FORMAT.getMessage());
    }

    @ParameterizedTest
    @MethodSource("orderLimitMenuTypeProvider")
    void 주문_메뉴_타입_제한_테스트(Integer visitDay, Map<String, Integer> orders) {
        assertThatThrownBy(() -> new OrderValidator().validate(visitDay, orders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.ANNOUNCE_ORDER_LIMIT_TYPE.getMessage());
    }

    @ParameterizedTest
    @MethodSource("orderLimitMenuCountProvider")
    void 주문_메뉴_개수_제한_테스트(Integer visitDay, Map<String, Integer> orders) {
        assertThatThrownBy(() -> new OrderValidator().validate(visitDay, orders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.ANNOUNCE_ORDER_LIMIT_COUNT.getMessage());
    }

    static Stream<Arguments> visitDayProvider() {
        return Stream.of(
                Arguments.of(Map.of("타파스", 1, "제로콜라", 1)),
                Arguments.of(Map.of("타파스", 1, "제로콜라", 2)),
                Arguments.of(Map.of("타파스", 1, "제로콜라", 2))
        );
    }

    static Stream<Arguments> orderLimitMenuTypeProvider() {
        return Stream.of(
                Arguments.of(7, Map.of("제로콜라", 2)),
                Arguments.of(7, Map.of("레드와인", 1, "샴페인", 2))
        );
    }

    static Stream<Arguments> orderLimitMenuCountProvider() {
        return Stream.of(
                Arguments.of(7, Map.of("타파스", 2, "제로콜라", 20)),
                Arguments.of(7, Map.of("시저샐러드", 5, "티본스테이크", 5, "크리스마스파스타", 7, "아이스크림", 5)),
                Arguments.of(7, Map.of("양송이수프", 3, "타파스", 3, "시저샐러드", 3, "티본스테이크", 3, "바비큐립", 3,
                        "해산물파스타", 3, "크리스마스파스타", 3, "초코케이크", 3, "아이스크림", 3))
        );
    }
}