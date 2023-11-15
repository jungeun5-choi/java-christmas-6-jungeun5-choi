package christmas.menu.model;

import christmas.common.enumerator.MenuType;

public record MenuData(
        MenuType type,
        String name,
        int price) {
}
