package christmas.common.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.common.enumerator.ExceptionMessage;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UtilTest {
    @Test
    void 입력값_형식_구분_테스트() {
        // given
        String input = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";

        // when
        Map<String, Integer> orders = Util.separateStringWithCommaAndHyphen(input);

        // then
        assertThat(orders.keySet()).contains("티본스테이크", "바비큐립", "초코케이크", "제로콜라");
        assertThat(orders.values()).contains(1, 1, 2, 1);
    }

    @Test
    void 입력값_공백_제거() {
        // given
        String input = "티본스 테 이크 - 1, 바 비 큐립 -1, 초코케이 크-2, 제 로콜라- 1";

        // when
        String order = Util.removeSpaceAll(input);

        // then
        assertThat(order).isEqualTo("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
    }

    @ParameterizedTest
    @MethodSource("inputDuplicatedTest")
    void 입력_메뉴_중복_예외_테스트(String input) {
        assertThatThrownBy(() -> Util.separateStringWithCommaAndHyphen(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_ORDER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @MethodSource("inputDuplicatedTest")
    void 입력_날짜_형식_예외_테스트(String input) {
        assertThatThrownBy(() -> Util.convertStringToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_DAY_FORMAT.getMessage());
    }

    static Stream<Arguments> inputDuplicatedTest() {
        return Stream.of(
                Arguments.of("a"),
                Arguments.of("123981751241243145"),
                Arguments.of("353po295AAA4o932865123")
        );
    }
}