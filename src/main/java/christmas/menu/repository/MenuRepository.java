package christmas.menu.repository;

import christmas.menu.model.MenuData;
import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private static List<MenuData> menuData = new ArrayList<>();

    public void save(MenuData menuData) {
        this.menuData.add(menuData);
    }

    public static MenuData findMenuByName(String name) {
        for (MenuData menu : menuData) {
            if (menu.name().equals(name)) {
                return menu;
            }
        }
        return null;
    }

    public List<MenuData> findAllMenuData() {
        return menuData;
    }
}
