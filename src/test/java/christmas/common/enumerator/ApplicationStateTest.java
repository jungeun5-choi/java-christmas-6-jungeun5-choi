package christmas.common.enumerator;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationStateTest extends NsTest {
    @Override
    protected void runMain() {

    }

    @Test
    void 상태_전환_테스트() {
        // given
        ApplicationState currentState = ApplicationState.CREATE_DATA;

        // when
        while (currentState.isAvailable()) {
            currentState = run(currentState);
        }

        // then
        assertThat(output()).contains(
                ApplicationState.CREATE_DATA.toString(),
                ApplicationState.RECEIVE_ORDER_DATA.toString(),
                ApplicationState.PRESENT_ORDER_DATA.toString(),
                ApplicationState.PROCESS_EVENT_PLANNER.toString(),
                ApplicationState.PRESENT_EVENT_PLANNER.toString(),
                ApplicationState.PRESENT_BADGE.toString()
        );
    }

    private ApplicationState run(ApplicationState currentState) {
        System.out.println(currentState);
        return currentState.next();
    }
}