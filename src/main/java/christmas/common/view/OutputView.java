package christmas.common.view;

import christmas.order.dto.OrderDto;
import java.util.Map;

public class OutputView {
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private static final int MONTH = 12;
    private static final String DIGIT_CRLF = "\n";

    public void printWelcomeMessage() {
        System.out.printf(Message.PRINT_WELCOME.message, MONTH);
    }

    public void printAdvantagePreviewMessage(int visitDay) {
        System.out.printf(Message.PRINT_ADVANTAGE_PREVIEW.message, MONTH, visitDay);
    }

    public void printOrderResult(OrderDto orderDto) {
        printOrderList(orderDto);
        printTotalOrderAmount(orderDto);
    }

    private void printOrderList(OrderDto orderDto) {
        System.out.printf(Message.PRINT_ORDER_LIST_TITLE.message);
        for (Map.Entry<String, Integer> entry : orderDto.getOrders().entrySet()) {
            System.out.printf(Message.PRINT_ORDER_LIST.message, entry.getKey(), entry.getValue());
        }
    }

    private void printTotalOrderAmount(OrderDto orderDto) {
        System.out.printf(Message.PRINT_TOTAL_ORDER_AMOUNT_TITLE.message);
        System.out.printf(Message.PRINT_TOTAL_ORDER_AMOUNT.message, orderDto.getTotalOrderAmount());
    }

    private enum Message {
        PRINT_WELCOME("안녕하세요! 우테코 식당 %s월 이벤트 플래너입니다.\n"),
        PRINT_ADVANTAGE_PREVIEW("%s월 %s일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),
        PRINT_ORDER_LIST_TITLE("\n<주문 메뉴>\n"),
        PRINT_ORDER_LIST("%s %s개\n"),
        PRINT_TOTAL_ORDER_AMOUNT_TITLE("\n<할인 전 총주문 금액>\n"),
        PRINT_TOTAL_ORDER_AMOUNT("%s원\n"),
        PRINT_REWARD_TITLE("<증정 메뉴>\n"),
        PRINT_REWARD("%s"),
        PRINT_ADVANTAGE_LIST_TITLE("<혜택 내역>\n"),
        PRINT_ADVANTAGE_LIST("%s: -%s원"),
        PRINT_ADVANTAGE_AMOUNT_TITLE("<총혜택 금액>\n"),
        PRINT_ADVANTAGE_AMOUNT("-%s원"),
        PRINT_FINAL_PAYMENT_TITLE("<할인 후 예상 결제 금액>"),
        PRINT_FINAL_PAYMENT("%s원"),
        PRINT_BADGE_TITLE("<12월 이벤트 배지>"),
        PRINT_BADGE("%s원"),
        ;

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
