package christmas.menu.model;

import christmas.util.enumerator.MenuType;
import java.util.List;

public record MenuData(
        MenuType menuType,
        List<FoodData> foodData) {
}
