package christmas.common;

import christmas.badge.controller.BadgeController;
import christmas.common.enumerator.ApplicationState;
import christmas.date.controller.DateController;
import christmas.event.controller.EventController;
import christmas.menu.controller.MenuController;
import java.util.Arrays;
import java.util.List;

public class MainController {
    private final List<Controller> controllers;

    public MainController(DateController dateController, EventController eventController, MenuController menuController,
                          BadgeController badgeController) {
        this.controllers = Arrays.asList(dateController, eventController, menuController, badgeController);
    }

    public void start() {
        ApplicationState currentState = ApplicationState.CREATE;
        run(currentState);
    }

    private void run(ApplicationState currentState) {
        for (Controller controller : controllers) {
            currentState.execute(controller);
        }
    }
}
