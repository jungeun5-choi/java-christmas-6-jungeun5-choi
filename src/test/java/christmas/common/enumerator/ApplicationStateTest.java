package christmas.common.enumerator;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplicationStateTest {
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    public void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    public void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    private String output() {
        return captor.toString().trim();
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