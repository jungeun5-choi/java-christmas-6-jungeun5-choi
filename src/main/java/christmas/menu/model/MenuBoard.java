package christmas.menu.model;

import java.util.List;

public class MenuBoard {
    private final List<MenuData> menuData;

    public MenuBoard(List<MenuData> menuData) {
        this.menuData = menuData;
    }

    public List<MenuData> getMenus() {
        return menuData;
    }
}
