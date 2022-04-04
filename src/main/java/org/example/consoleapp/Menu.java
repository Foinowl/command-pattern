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
            System.out.println("   ");
            System.out.println("----------------------------------------");
            menuService
                .getMenu()
                .writeMenuToMap()
                .printMenu()
                .getOptionSelection()
                .getCommand(ServiceFactory.getInstance().getMenuService().getSelectedOption())
                .execute();

        }
    }
}
