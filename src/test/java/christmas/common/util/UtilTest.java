package christmas.common.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

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
}