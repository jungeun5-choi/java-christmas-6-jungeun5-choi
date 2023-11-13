package christmas.menu.model;

import christmas.common.enumerator.MenuType;

public record MenuData(
        MenuType menuType,
        String name,
        int price) {
}
