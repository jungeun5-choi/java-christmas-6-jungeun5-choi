package christmas.common.enumerator;

public enum ExceptionMessage {
    INVALID_DAY_FORMAT("유효하지 않은 날짜입니다."),
    INVALID_ORDER_FORMAT("유효하지 않은 주문입니다."),
    ANNOUNCE_ORDER_LIMIT_TYPE("음료만 주문하는 것은 불가능합니다."),
    ANNOUNCE_ORDER_LIMIT_COUNT("한 번에 최대 20개까지만 주문 가능합니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s 다시 입력해 주세요.";

    private final String message;

    ExceptionMessage(String message, Object... replaces) {
        this.message = String.format(BASE_MESSAGE, String.format(message, replaces));
    }

    public String getMessage() {
        return message;
    }
}
