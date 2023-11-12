package christmas.menu.controller;

import christmas.menu.service.MenuService;

public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    public void createMenu() {
        menuService.createMenu();
    }
}
