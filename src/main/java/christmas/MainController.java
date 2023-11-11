package christmas;

import christmas.date.controller.InitializeDateController;
import christmas.event.controller.InitializeEventController;
import christmas.menu.controller.InitializeMenuController;

public class MainController {
    private InitializeDateController initializeDateController = new InitializeDateController();
    private InitializeMenuController initializeMenuController = new InitializeMenuController();
    private InitializeEventController initializeEventController = new InitializeEventController();

    public void run() {
        initializeDateController.process();
        initializeMenuController.process();
        initializeEventController.process();
    }
}
