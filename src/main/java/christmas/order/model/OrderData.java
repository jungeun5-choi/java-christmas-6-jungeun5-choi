package christmas.order.model;

import christmas.common.enumerator.ExceptionMessage;
import java.util.Map;

public record OrderData(
        int visitDay,
        Map<String, Integer> orders) {

    private static final int MIN_DAY = 1;
    private static final int MAX_DAY = 31;

    public OrderData {
        validate(visitDay, orders);
    }

    private void validate(int visitDay, Map<String, Integer> orders) throws IllegalArgumentException {
        validateVisitDay(visitDay);
    }

    private void validateVisitDay(int visitDay) {
        if (visitDay < MIN_DAY) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DAY_FORMAT.getMessage());
        }
        if (visitDay > MAX_DAY) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DAY_FORMAT.getMessage());
        }
    }
}