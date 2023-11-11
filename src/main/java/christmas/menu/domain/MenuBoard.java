package christmas.menu.domain;

import java.util.List;

public class MenuBoard {
    private final List<Menu> menus;

    public MenuBoard(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
