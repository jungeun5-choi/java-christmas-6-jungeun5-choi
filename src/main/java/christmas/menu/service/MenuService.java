package christmas.menu.service;

import christmas.menu.model.FoodData;
import christmas.menu.model.MenuBoard;
import christmas.menu.model.MenuData;
import christmas.common.enumerator.MenuType;
import java.util.ArrayList;
import java.util.List;

public class MenuService {
    public MenuBoard createMenu() {
        List<MenuData> menuData = new ArrayList<>();
        menuData.add(createAppetizer());
        menuData.add(createMain());
        menuData.add(createDessert());
        menuData.add(createDrink());
        return new MenuBoard(menuData);
    }

    private MenuData createAppetizer() {
        List<FoodData> appetizers = new ArrayList<>();
        appetizers.add(new FoodData("양송이수프", 6000));
        appetizers.add(new FoodData("타파스", 5500));
        appetizers.add(new FoodData("시저샐러드", 8000));
        return new MenuData(MenuType.Appetizer, appetizers);
    }

    private MenuData createMain() {
        List<FoodData> mains = new ArrayList<>();
        mains.add(new FoodData("티본스테이크", 55000));
        mains.add(new FoodData("바비큐립", 54000));
        mains.add(new FoodData("해산물파스타", 35000));
        mains.add(new FoodData("크리스마스파스타", 25000));
        return new MenuData(MenuType.Main, mains);
    }

    private MenuData createDessert() {
        List<FoodData> desserts = new ArrayList<>();
        desserts.add(new FoodData("초코케이크", 15000));
        desserts.add(new FoodData("아이스크림", 5000));
        return new MenuData(MenuType.Dessert, desserts);
    }

    private MenuData createDrink() {
        List<FoodData> drinks = new ArrayList<>();
        drinks.add(new FoodData("제로콜라", 3000));
        drinks.add(new FoodData("레드와인", 60000));
        drinks.add(new FoodData("샴페인", 25000));
        return new MenuData(MenuType.Appetizer, drinks);
    }
}