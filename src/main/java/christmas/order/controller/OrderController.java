package christmas.order.controller;

import christmas.common.controller.Controller;
import christmas.common.enumerator.ApplicationState;
import christmas.common.view.InputView;
import christmas.common.view.OutputView;
import christmas.order.dto.OrderDto;
import christmas.order.service.OrderService;
import java.util.Map;

public class OrderController extends Controller {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;

        stateActions.put(ApplicationState.RECEIVE_ORDER_DATA, this::receive);
        stateActions.put(ApplicationState.PRESENT_ORDER_DATA, this::present);
    }

    public void receive() {
        try {
            int visitDay = InputView.getInstance().readVisitDay();
            Map<String, Integer> orders = InputView.getInstance().readOrderList();
            orderService.save(visitDay, orders);
        } catch (IllegalArgumentException exception) {
            OutputView.getInstance().printExceptionMessage(exception);
            receive();
        }
    }

    public void present() {
        OrderDto orderDto = orderService.present();
        printOrderResult(orderDto);
    }

    private void printOrderResult(OrderDto orderDto) {
        OutputView.getInstance().printAdvantagePreviewMessage(orderDto.getVisitDay());
        OutputView.getInstance().printOrderList(orderDto);
        OutputView.getInstance().printTotalOrderAmount(orderDto);
    }
}
