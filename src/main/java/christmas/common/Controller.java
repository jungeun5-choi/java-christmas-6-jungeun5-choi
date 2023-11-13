package christmas.common;

import christmas.common.enumerator.ApplicationState;
import java.util.HashMap;
import java.util.Map;

public abstract class Controller {
    protected ApplicationState currentState;
    protected Map<ApplicationState, Runnable> stateActions = new HashMap<>();

    protected void setState(ApplicationState currentState) {
        this.currentState = currentState;
    }

    protected void executeState() {
        Runnable action = stateActions.get(currentState);
        if (action != null) {
            action.run();
        }
    }

    public abstract void create();
}
