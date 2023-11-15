package christmas.common.enumerator;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationStateTest extends NsTest {
    private static final String LINE_Separator = System.lineSeparator();

    @Test
    void 상태_전환_테스트() {
        // given
        ApplicationState currentState = ApplicationState.CREATE_DATA;

        // when
        while (currentState.isAvailable()) {
            currentState = run(currentState);
        }

        // then
        assertThat(output()).isEqualTo(
                ApplicationState.CREATE_DATA + LINE_Separator
                        + ApplicationState.RECEIVE_ORDER_DATA + LINE_Separator
                        + ApplicationState.PRESENT_ORDER_DATA + LINE_Separator
                        + ApplicationState.PROCESS_EVENT_PLANNER + LINE_Separator
                        + ApplicationState.PRESENT_EVENT_PLANNER + LINE_Separator
                        + ApplicationState.PRESENT_BADGE
        );
    }

    private ApplicationState run(ApplicationState currentState) {
        System.out.println(currentState);
        return currentState.next();
    }

    @Override
    protected void runMain() {

    }
}