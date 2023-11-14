package christmas.common;

import christmas.badge.controller.BadgeController;
import christmas.badge.service.BadgeService;
import christmas.common.controller.MainController;
import christmas.common.view.InputView;
import christmas.common.view.OutputView;
import christmas.date.controller.DateController;
import christmas.date.repository.DateRepository;
import christmas.date.service.DateService;
import christmas.event.controller.EventController;
import christmas.event.repository.EventRepository;
import christmas.event.service.EventService;
import christmas.eventPlanner.controller.EventPlannerController;
import christmas.eventPlanner.service.EventPlannerService;
import christmas.menu.controller.MenuController;
import christmas.menu.repository.MenuRepository;
import christmas.menu.service.MenuService;
import christmas.order.controller.OrderController;
import christmas.order.repository.OrderRepository;
import christmas.order.service.OrderService;

public class ApplicationContext {
    private DateRepository dateRepository;
    private EventRepository eventRepository;
    private MenuRepository menuRepository;
    private OrderRepository orderRepository;
    private DateService dateService;
    private EventService eventService;
    private MenuService menuService;
    private BadgeService badgeService;
    private OrderService orderService;
    private EventPlannerService eventPlannerService;

    public ApplicationContext() {
        initializeRepository();
        initializeService();
    }

    private void initializeRepository() {
        dateRepository = new DateRepository();
        menuRepository = new MenuRepository();
        orderRepository = new OrderRepository();
    }

    private void initializeService() {
        dateService = new DateService(dateRepository);
        eventService = new EventService(eventRepository);
        menuService = new MenuService(menuRepository);
        badgeService = new BadgeService();
        orderService = new OrderService(orderRepository, menuRepository);
        eventPlannerService = new EventPlannerService();
    }

    public MainController InitializeController() {
        DateController dateController = new DateController(dateService);
        EventController eventController = new EventController(eventService);
        MenuController menuController = new MenuController(menuService);
        BadgeController badgeController = new BadgeController(badgeService);
        OrderController orderController = new OrderController(orderService);
        EventPlannerController eventPlannerController = new EventPlannerController(eventPlannerService);
        return new MainController(dateController, eventController, menuController, badgeController, orderController,
                eventPlannerController);
    }
}
