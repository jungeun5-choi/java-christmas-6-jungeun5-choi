package christmas.common.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.common.enumerator.ExceptionMessage;
import christmas.common.util.Util;
import java.util.Map;
import java.util.regex.Pattern;

public class InputView {
    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private static final Pattern REGEX_ORDER_FORMAT = Pattern.compile("\\w+-\\w");
    private static final int MONTH = 12;

    public int readVisitDay() {
        try {
            System.out.printf(Message.INPUT_VISIT_DAY.message, MONTH);
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DAY_FORMAT.getMessage());
        }
    }

    public Map<String, Integer> readOrderList() {
        System.out.printf(Message.INPUT_ORDER_MENU_AND_COUNT.message);
        return Util.separateStringWithCommaAndHyphen(Console.readLine());
    }

    private enum Message {
        INPUT_VISIT_DAY("%s월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)\n"),
        INPUT_ORDER_MENU_AND_COUNT("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)\n");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
