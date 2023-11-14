package christmas.order.model;

import christmas.common.enumerator.ExceptionMessage;
import christmas.common.enumerator.MenuType;
import christmas.menu.repository.MenuRepository;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public record OrderData(int visitDay, Map<String, Integer> orders) {
    private static final int MIN_DAY = 1;
    private static final int MAX_DAY = 31;
    private static final int MAX_MENU = 20;

    public OrderData {
        validate(visitDay, orders);
    }

    private void validate(int visitDay, Map<String, Integer> orders) {
        validateVisitDay(visitDay);
        validateMenuName(orders);
        validateOrderLimit(orders);
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

    private void validateOrderLimit(Map<String, Integer> orders) {
        checkMenuType(orders);
        checkMenuCount(orders);
    }

    private void checkMenuType(Map<String, Integer> orders) {
        Set<MenuType> types = findAllTypesFromOrders(orders);
        if (hasOnlyDrink(types)) {
            throw new IllegalArgumentException(ExceptionMessage.ANNOUNCE_ORDER_LIMIT_TYPE.getMessage());
        }
    }

    private void checkMenuCount(Map<String, Integer> orders) {
        int menuCount = calculateMenuCounts(orders);
        if (menuCount > MAX_MENU) {
            throw new IllegalArgumentException(ExceptionMessage.ANNOUNCE_ORDER_LIMIT_COUNT.getMessage());
        }
    }

    private void validateMenuDuplicate(Map<String, Integer> orders) {
        Set<String> names = new HashSet<>(orders.keySet());
        if (hasDuplicate(orders, names)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_FORMAT.getMessage());
        }
    }

    private Set<MenuType> findAllTypesFromOrders(Map<String, Integer> orders) {
        return orders.keySet()
                .stream()
                .map(this::findMenuTypeByName)
                .collect(Collectors.toSet());
    }

    private int calculateMenuCounts(Map<String, Integer> orders) {
        return orders.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private MenuType findMenuTypeByName(String name) {
        return Objects.requireNonNull(MenuRepository.findMenuByName(name)).type();
    }

    private boolean hasOnlyDrink(Set<MenuType> types) {
        return types.contains(MenuType.Drink) && types.size() == 1;
    }

    private boolean hasDuplicate(Map<String, Integer> orders, Set<String> names) {
        return names.size() < orders.size();
    }
}