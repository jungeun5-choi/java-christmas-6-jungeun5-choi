package christmas.menu.model;

import christmas.util.enumerator.MenuType;
import java.util.List;

public record Menu(
        MenuType menuType,
        List<Food> foods) {
}
