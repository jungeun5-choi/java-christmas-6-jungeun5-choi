package christmas.common.controller;

import christmas.badge.controller.BadgeController;
import christmas.common.enumerator.ApplicationState;
import christmas.common.view.OutputView;
import christmas.date.controller.DateController;
import christmas.event.controller.EventController;
import christmas.eventPlanner.controller.AdvantageController;
import christmas.menu.controller.MenuController;
import christmas.order.controller.OrderController;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainController {
    private Map<ApplicationState, List<Controller>> controllers = new HashMap<>();

    public MainController(DateController dateController, EventController eventController, MenuController menuController,
                          BadgeController badgeController, OrderController orderController,
                          AdvantageController advantageController) {
        setStateToController(dateController, eventController, menuController, badgeController, orderController,
                advantageController);
    }

    private void setStateToController(DateController dateController, EventController eventController,
                           MenuController menuController, BadgeController badgeController,
                           OrderController orderController, AdvantageController advantageController) {
        controllers.put(ApplicationState.CREATE_DATA,
                Arrays.asList(dateController, eventController, menuController, badgeController));
        controllers.put(ApplicationState.RECEIVE_ORDER_DATA, Collections.singletonList(orderController));
        controllers.put(ApplicationState.PRESENT_ORDER_DATA, Collections.singletonList(orderController));
        controllers.put(ApplicationState.PROCESS_EVENT_PLANNER, Collections.singletonList(advantageController));
        controllers.put(ApplicationState.PRESENT_EVENT_PLANNER, Collections.singletonList(advantageController));
    }

    public void start() {
        printWelcomeMessage();
        ApplicationState currentState = ApplicationState.CREATE_DATA;
        while (currentState.isAvailable()) {
            currentState = run(currentState);
        }
    }

    private ApplicationState run(ApplicationState currentState) {
        for (Controller controller : controllers.get(currentState)) {
            controller.setState(currentState);
            controller.executeState();
        }
        return currentState.next();
    }

    private void printWelcomeMessage() {
        OutputView.getInstance().printWelcomeMessage();
    }
}
