package christmas.common.enumerator;

public enum ExceptionMessage {
    INVALID_INPUT_FORMAT("");

    public static final String BASE_MESSAGE = "[ERROR] %s";

    private final String message;

    ExceptionMessage(String message, Object... replaces) {
        this.message = String.format(BASE_MESSAGE, String.format(message, replaces));
    }

    public String getMessage() {
        return message;
    }
}
