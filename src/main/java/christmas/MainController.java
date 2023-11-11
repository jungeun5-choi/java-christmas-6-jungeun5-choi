package christmas;

import christmas.date.controller.InitializeDateController;
import christmas.menu.controller.InitializeMenuController;

public class MainController {
    private InitializeDateController initializeDateController = new InitializeDateController();
    private InitializeMenuController initializeMenuController = new InitializeMenuController();

    public void run() {
        initializeDateController.process();
        initializeMenuController.process();
    }
}
