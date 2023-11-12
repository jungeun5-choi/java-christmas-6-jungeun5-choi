package christmas.menu.model;

import java.util.List;

public class Menu {
    private final List<MenuData> menuData;

    public Menu(List<MenuData> menuData) {
        this.menuData = menuData;
    }

    public List<MenuData> getMenus() {
        return menuData;
    }
}
