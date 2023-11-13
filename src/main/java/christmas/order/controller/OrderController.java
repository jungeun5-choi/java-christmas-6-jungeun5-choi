package christmas.order.controller;

import christmas.common.controller.Controller;
import christmas.common.enumerator.ApplicationState;
import christmas.common.view.InputView;
import christmas.common.view.OutputView;
import christmas.order.service.OrderService;
import java.util.Map;

public class OrderController extends Controller {
    private final OrderService orderService;
    private final InputView inputView;
    private final OutputView outputView;

    public OrderController(OrderService orderService, InputView inputView, OutputView outputView) {
        this.orderService = orderService;
        this.inputView = inputView;
        this.outputView = outputView;

        stateActions.put(ApplicationState.RECEIVE_ORDER_DATA, this::receive);
        stateActions.put(ApplicationState.PRESENT_ORDER_DATA, this::present);
    }

    public void receive() {
        try {
            int visitDay = inputView.readVisitDay();
            Map<String, Integer> orders = inputView.readOrderList();
            orderService.save(visitDay, orders);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            receive();
        }
    }

    public void present() {
        outputView.printOrderResult(orderService.present());
    }
}
