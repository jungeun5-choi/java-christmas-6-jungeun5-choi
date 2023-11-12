package christmas.menu.controller;

import christmas.menu.model.Food;
import christmas.menu.model.Menu;
import christmas.menu.model.MenuBoard;
import christmas.util.Controllable;
import christmas.util.enumerator.MenuType;
import java.util.ArrayList;
import java.util.List;

public class InitializeMenuController implements Controllable {
    @Override
    public void process() {
        MenuBoard menuBoard = new MenuBoard(initialize());
    }

    private List<Menu> initialize() {
        List<Menu> menus = new ArrayList<>();
        menus.add(initializeAppetizer());
        menus.add(initializeMain());
        menus.add(initializeDessert());
        menus.add(initializeDrink());
        return menus;
    }

    private Menu initializeAppetizer() {
        List<Food> appetizers = new ArrayList<>();
        appetizers.add(new Food("양송이수프", 6000));
        appetizers.add(new Food("타파스", 5500));
        appetizers.add(new Food("시저샐러드", 8000));
        return new Menu(MenuType.Appetizer, appetizers);
    }

    private Menu initializeMain() {
        List<Food> mains = new ArrayList<>();
        mains.add(new Food("티본스테이크", 55000));
        mains.add(new Food("바비큐립", 54000));
        mains.add(new Food("해산물파스타", 35000));
        mains.add(new Food("크리스마스파스타", 25000));
        return new Menu(MenuType.Main, mains);
    }

    private Menu initializeDessert() {
        List<Food> desserts = new ArrayList<>();
        desserts.add(new Food("초코케이크", 15000));
        desserts.add(new Food("아이스크림", 5000));
        return new Menu(MenuType.Dessert, desserts);
    }

    private Menu initializeDrink() {
        List<Food> drinks = new ArrayList<>();
        drinks.add(new Food("제로콜라", 3000));
        drinks.add(new Food("레드와인", 60000));
        drinks.add(new Food("샴페인", 25000));
        return new Menu(MenuType.Appetizer, drinks);
    }
}