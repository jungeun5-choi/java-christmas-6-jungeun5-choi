package christmas.common.view;

import christmas.common.enumerator.EventType;
import christmas.event.model.EventData;
import christmas.order.dto.OrderDto;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final int MONTH = 12;
    private static final String REWARD_ITEM = "샴페인";
    private static final int REWARD_ITEM_COUNT = 1;

    public void printWelcomeMessage() {
        System.out.printf(Message.PRINT_WELCOME.message + LINE_SEPARATOR, MONTH);
    }

    public void printAdvantagePreviewMessage(int visitDay) {
        System.out.printf(Message.PRINT_ADVANTAGE_PREVIEW.message + LINE_SEPARATOR, MONTH, visitDay);
    }

    public void printOrderResult(OrderDto orderDto) {
        printOrderList(orderDto);
        printTotalOrderAmount(orderDto);
    }

    private void printOrderList(OrderDto orderDto) {
        System.out.printf(Message.PRINT_ORDER_LIST_TITLE.message + LINE_SEPARATOR);
        for (Map.Entry<String, Integer> entry : orderDto.getOrders().entrySet()) {
            System.out.printf(Message.PRINT_ORDER_LIST.message + LINE_SEPARATOR,
                    entry.getKey(), entry.getValue());
        }
    }

    private void printTotalOrderAmount(OrderDto orderDto) {
        System.out.printf(Message.PRINT_TOTAL_ORDER_AMOUNT_TITLE.message + LINE_SEPARATOR);
        System.out.printf(Message.PRINT_TOTAL_ORDER_AMOUNT.message + LINE_SEPARATOR, orderDto.getTotalOrderAmount());
    }

    public void printReward(boolean hasReward) {
        System.out.printf(Message.PRINT_REWARD_TITLE.message + LINE_SEPARATOR);
        if (hasReward) {
            System.out.printf(Message.PRINT_REWARD.message + LINE_SEPARATOR, REWARD_ITEM, REWARD_ITEM_COUNT);
        }
        if (!hasReward) {
            System.out.printf(Message.PRINT_ADVANTAGE_EMPTY.message + LINE_SEPARATOR);
        }
    }

    public void printAdvantageList(List<EventData> eventData, Map<EventType, Integer> discounts, boolean hasAdvantage) {
        System.out.printf(Message.PRINT_ADVANTAGE_LIST_TITLE.message + LINE_SEPARATOR);
        if (hasAdvantage) {
            printAllAdvantages(eventData, discounts);
        }
        if (!hasAdvantage) {
            System.out.printf(Message.PRINT_ADVANTAGE_EMPTY.message + LINE_SEPARATOR);
        }
    }

    private void printAllAdvantages(List<EventData> eventData, Map<EventType, Integer> discounts) {
        for (EventData event : eventData) {
            System.out.printf(Message.PRINT_ADVANTAGE_LIST.message + LINE_SEPARATOR,
                    event.name(), discounts.get(event.type()));
        }
    }

    public void printAdvantageAmount(int amount) {
        System.out.printf(Message.PRINT_ADVANTAGE_AMOUNT_TITLE.message + LINE_SEPARATOR);
        System.out.printf(Message.PRINT_ADVANTAGE_AMOUNT.message + LINE_SEPARATOR, amount);
    }

    public void printFinalPayment(int amount) {
        System.out.printf(Message.PRINT_FINAL_PAYMENT_TITLE.message + LINE_SEPARATOR);
        System.out.printf(Message.PRINT_FINAL_PAYMENT.message + LINE_SEPARATOR, amount);
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printBadge(String badgeName) {
        System.out.printf(Message.PRINT_BADGE_TITLE.message + LINE_SEPARATOR);
        System.out.printf(Message.PRINT_BADGE.message + LINE_SEPARATOR, badgeName);
    }

    private enum Message {
        PRINT_WELCOME("안녕하세요! 우테코 식당 %s월 이벤트 플래너입니다."),
        PRINT_ADVANTAGE_PREVIEW("\n%s월 %s일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
        PRINT_ORDER_LIST_TITLE("\n<주문 메뉴>"),
        PRINT_ORDER_LIST("%s %s개"),
        PRINT_TOTAL_ORDER_AMOUNT_TITLE("\n<할인 전 총주문 금액>"),
        PRINT_TOTAL_ORDER_AMOUNT("%s원"),
        PRINT_REWARD_TITLE("\n<증정 메뉴>"),
        PRINT_REWARD("%s %s개"),
        PRINT_ADVANTAGE_LIST_TITLE("\n<혜택 내역>"),
        PRINT_ADVANTAGE_LIST("%s: -%s원"),
        PRINT_ADVANTAGE_AMOUNT_TITLE("\n<총혜택 금액>"),
        PRINT_ADVANTAGE_AMOUNT("-%s원"),
        PRINT_FINAL_PAYMENT_TITLE("\n<할인 후 예상 결제 금액>"),
        PRINT_FINAL_PAYMENT("%s원"),
        PRINT_BADGE_TITLE("\n<12월 이벤트 배지>"),
        PRINT_BADGE("%s"),
        PRINT_ADVANTAGE_EMPTY("없음"),
        ;

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
