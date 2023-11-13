package christmas.order.controller;

import christmas.common.controller.Controller;
import christmas.common.enumerator.ApplicationState;
import christmas.common.view.InputView;
import christmas.common.view.OutputView;
import christmas.order.model.Order;
import christmas.order.service.OrderService;
import java.util.Map;

public class OrderController extends Controller {
    private final OrderService orderService;
    private final InputView inputView;
    private final OutputView outputview;

    public OrderController(OrderService orderService, InputView inputView, OutputView outputview) {
        this.orderService = orderService;
        this.inputView = inputView;
        this.outputview = outputview;

        stateActions.put(ApplicationState.RECEIVE_ORDER_DATA, this::receive);
        stateActions.put(ApplicationState.PROCESS_ORDER, this::order);

    }

    public void receive() {
        int visitDay = inputView.readVisitDay();
        Map<String, Integer> orders = inputView.readOrderList();
        Order order = orderService.save(visitDay, orders);
        outputview.printOrderList(order);
    }

    public void order() {

    }
}
