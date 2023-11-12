package christmas.menu.controller;

import christmas.common.Controller;
import christmas.common.enumerator.ApplicationState;
import christmas.menu.model.MenuBoard;
import christmas.menu.model.MenuData;
import christmas.menu.service.MenuService;

public class MenuController extends Controller {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
        stateActions.put(ApplicationState.CREATE, this::create);
    }

    @Override
    public void create() {
        MenuBoard menuBoard = menuService.createMenu();
        for (MenuData data : menuBoard.getMenus()) {
            System.out.println(data.menuType());
            for (int i = 0; i < data.foodData().size(); i++) {
                System.out.print("이름: " + data.foodData().get(i).name());
                System.out.print(" / 가격: " + data.foodData().get(i).price());
                System.out.println();
            }
            System.out.println();
        }
    }
}
