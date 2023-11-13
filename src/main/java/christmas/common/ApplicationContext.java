package christmas.common;

import christmas.badge.controller.BadgeController;
import christmas.badge.service.BadgeService;
import christmas.date.controller.DateController;
import christmas.date.service.DateService;
import christmas.event.controller.EventController;
import christmas.event.service.EventService;
import christmas.menu.controller.MenuController;
import christmas.menu.service.MenuService;

public class ApplicationContext {
    private DateService dateService;
    private EventService eventService;
    private MenuService menuService;
    private BadgeService badgeService;

    public ApplicationContext() {
        dateService = new DateService();
        eventService = new EventService();
        menuService = new MenuService();
        badgeService = new BadgeService();
    }

    public MainController InitializeController() {
        DateController dateController = new DateController(dateService);
        EventController eventController = new EventController(eventService);
        MenuController menuController = new MenuController(menuService);
        BadgeController badgeController = new BadgeController(badgeService);
        return new MainController(dateController, eventController, menuController, badgeController);
    }
}
