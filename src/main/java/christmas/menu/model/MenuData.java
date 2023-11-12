package christmas.menu.model;

import christmas.common.enumerator.MenuType;
import java.util.List;

public record MenuData(
        MenuType menuType,
        List<FoodData> foodData) {
}
