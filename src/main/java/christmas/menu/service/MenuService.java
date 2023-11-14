package christmas.menu.service;

import christmas.common.enumerator.MenuType;
import christmas.menu.model.MenuData;
import christmas.menu.repository.MenuRepository;

public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void createMenu() {
        menuRepository.save(new MenuData(MenuType.Appetizer,"양송이수프", 6000));
        menuRepository.save(new MenuData(MenuType.Appetizer,"타파스", 5500));
        menuRepository.save(new MenuData(MenuType.Appetizer,"시저샐러드", 8000));
        menuRepository.save(new MenuData(MenuType.Main,"티본스테이크", 55000));
        menuRepository.save(new MenuData(MenuType.Main,"바비큐립", 54000));
        menuRepository.save(new MenuData(MenuType.Main,"해산물파스타", 35000));
        menuRepository.save(new MenuData(MenuType.Main,"크리스마스파스타", 25000));
        menuRepository.save(new MenuData(MenuType.Dessert,"초코케이크", 15000));
        menuRepository.save(new MenuData(MenuType.Dessert,"아이스크림", 5000));
        menuRepository.save(new MenuData(MenuType.Drink,"제로콜라", 3000));
        menuRepository.save(new MenuData(MenuType.Drink,"레드와인", 60000));
        menuRepository.save(new MenuData(MenuType.Drink,"샴페인", 25000));
    }
}