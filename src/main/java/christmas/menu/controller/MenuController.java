package christmas.menu.controller;

import christmas.common.controller.Controller;
import christmas.common.controller.Initializable;
import christmas.common.enumerator.ApplicationState;
import christmas.menu.service.MenuService;

public class MenuController extends Controller implements Initializable {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
        stateActions.put(ApplicationState.CREATE_DATA, this::initialize);
    }

    @Override
    public void initialize() {
        menuService.createMenu();
    }
}
