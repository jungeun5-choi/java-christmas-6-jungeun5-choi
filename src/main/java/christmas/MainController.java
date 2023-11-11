package christmas;

import christmas.date.controller.InitializeDateController;

public class MainController {

    InitializeDateController initializeDateController = new InitializeDateController();

    public void run() {
        initializeDateController.process();
    }
}
