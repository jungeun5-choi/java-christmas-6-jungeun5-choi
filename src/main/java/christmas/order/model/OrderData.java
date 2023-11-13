package christmas.order.model;

import christmas.common.enumerator.ExceptionMessage;
import christmas.menu.repository.MenuRepository;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public record OrderData(int visitDay, Map<String, Integer> orders) {

    private static final int MIN_DAY = 1;
    private static final int MAX_DAY = 31;

    public OrderData {
        validate(visitDay, orders);
    }

    private void validate(int visitDay, Map<String, Integer> orders) {
        validateVisitDay(visitDay);
        validateMenuName(orders);
        if (orders.size() > 1) {
            validateMenuDuplicate(orders);
        }
    }

    private void validateVisitDay(int visitDay) {
        if (visitDay < MIN_DAY) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DAY_FORMAT.getMessage());
        }
        if (visitDay > MAX_DAY) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DAY_FORMAT.getMessage());
        }
    }

    private void validateMenuName(Map<String, Integer> orders) {
        try {
            for (String menuName : orders.keySet()) {
                MenuRepository.findMenuByName(menuName);
            }
        } catch (NullPointerException exception) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_FORMAT.getMessage());
        }
    }

    private void validateMenuDuplicate(Map<String, Integer> orders) {
        Set<String> names = new HashSet<>(orders.keySet());
        if (hasDuplicate(orders, names)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_FORMAT.getMessage());
        }
    }

    private boolean hasDuplicate(Map<String, Integer> orders, Set<String> names) {
        return names.size() < orders.size();
    }
}