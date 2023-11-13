package christmas.common;

import christmas.badge.controller.BadgeController;
import christmas.badge.service.BadgeService;
import christmas.common.controller.MainController;
import christmas.common.view.InputView;
import christmas.common.view.OutputView;
import christmas.date.controller.DateController;
import christmas.date.service.DateService;
import christmas.event.controller.EventController;
import christmas.event.service.EventService;
import christmas.menu.controller.MenuController;
import christmas.menu.service.MenuService;
import christmas.order.controller.OrderController;
import christmas.order.service.OrderService;

public class ApplicationContext {
    private DateService dateService;
    private EventService eventService;
    private MenuService menuService;
    private BadgeService badgeService;
    private OrderService orderService;

    public ApplicationContext() {
        dateService = new DateService();
        eventService = new EventService();
        menuService = new MenuService();
        badgeService = new BadgeService();
        orderService = new OrderService();
    }

    public MainController InitializeController() {
        DateController dateController = new DateController(dateService);
        EventController eventController = new EventController(eventService);
        MenuController menuController = new MenuController(menuService);
        BadgeController badgeController = new BadgeController(badgeService);
        OrderController orderController = new OrderController(orderService, InputView.getInstance(), OutputView.getInstance());
        return new MainController(dateController, eventController, menuController, badgeController, orderController);
    }
}
