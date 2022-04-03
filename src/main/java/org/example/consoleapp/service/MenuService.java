package org.example.consoleapp.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import org.example.consoleapp.service.factory.ServiceFactory;

public class MenuService {
    private final Scanner scanner;
    private final String MENU_FILE_PROPERTIES = "menu.properties";
    private final Map<String, String> menuHierarchy;
    private Properties properties;
    private String selectedOption;

    public MenuService() {
        this.scanner = new Scanner(System.in);
        this.menuHierarchy = new HashMap<>();
    }

    public MenuService writeMenuToMap() {
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            menuHierarchy.put((String) entry.getKey(), (String) entry.getValue());
        }
        return this;
    }

    public MenuService getMenu() {
        properties = ServiceFactory
            .getInstance()
            .getPropertyService()
            .readFromPropertiesFile(MENU_FILE_PROPERTIES);
        return this;
    }

    public void getOptionSelection() {
        printToConsole("Input a number of the described options");
        selectedOption = scanner.next();
        printToConsole("you've selected the option : " + selectedOption);
    }

    public MenuService printMenu() {
        for (Map.Entry<String, String> entry : menuHierarchy.entrySet()) {
            printToConsole(entry.getKey() + ". " + entry.getValue());
        }
        return this;
    }

    private void printToConsole(String line) {
        System.out.println(line);
    }
}
