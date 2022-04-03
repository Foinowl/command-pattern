package org.example.consoleapp;

import org.example.consoleapp.service.MenuService;
import org.example.consoleapp.service.factory.ServiceFactory;

public class Menu {
    private final static Menu instance = new Menu();
    private final MenuService menuService = ServiceFactory.getInstance().getMenuService();

    public Menu() {
    }

    public static Menu getInstance() {
        return instance;
    }

    public void runMenu() {
        while (true) {
            menuService
                .getMenu()
                .writeMenuToMap()
                .printMenu()
                .getOptionSelection();
        }
    }
}
