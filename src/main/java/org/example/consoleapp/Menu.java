package org.example.consoleapp;

import org.example.consoleapp.service.MenuService;
import org.example.consoleapp.service.factory.ServiceFactory;

public class Menu {
    private static Menu INSTANCE;
    private final MenuService menuService;

    private Menu(MenuService menuService) {
        this.menuService = menuService;
    }

    public static Menu of() {
        if (INSTANCE == null) {
            INSTANCE = new Menu(ServiceFactory.getInstance().getMenuService());
        }
        return INSTANCE;
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
