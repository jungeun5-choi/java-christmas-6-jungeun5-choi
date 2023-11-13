package christmas;

import christmas.common.ApplicationContext;
import christmas.common.MainController;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext();

        MainController mainController = applicationContext.InitializeController();
        mainController.start();
    }
}
