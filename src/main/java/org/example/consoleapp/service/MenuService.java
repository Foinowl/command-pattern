package org.example.consoleapp.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.example.consoleapp.command.factory.CommandDefiner;
import org.example.consoleapp.entity.Location;
import org.example.consoleapp.service.factory.ServiceFactory;

public class MenuService {
    private final Logger LOGGER = Logger.getLogger(MenuService.class);

    private final JsonService jsonService;

    private final PropertyService propertyService;

    private final CommandService commandService;

    private final StoreService storeService;

    private final CommandDefiner commandDefiner;

    private final Scanner scanner;

    private final String MENU_FILE_PROPERTIES = "menu.properties";

    private final Map<String, String> menuHierarchy;

    private Properties properties;

    private String selectedOption;

    private String selectedId;

    public MenuService(final PropertyService propertyService,
                       final JsonService jsonService,
                       final CommandService commandService){
        this.propertyService = propertyService;
        this.jsonService = jsonService;
        this.commandService = commandService;
        this.storeService = new StoreService(jsonService);
        this.commandDefiner = new CommandDefiner(this);

        this.scanner = new Scanner(System.in);
        this.menuHierarchy = new HashMap<>();
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public MenuService writeMenuToMap() {
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            menuHierarchy.put((String) entry.getKey(), (String) entry.getValue());
        }
        return this;
    }

    public MenuService getMenu() {
        properties = propertyService.readFromPropertiesFile(MENU_FILE_PROPERTIES);
        return this;
    }

    public CommandDefiner getOptionSelection() {
        printToConsole("Input a number of the described options");
        selectedOption = scanner.next();
        printToConsole("you've selected the option : " + selectedOption);
        return commandDefiner;
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


    public int requestForPowerInput() {
        int powerEntered = 0;
        boolean inputIsWrong = true;
        while (inputIsWrong) {
            try {
                printToConsole("Enter the power value to search for a device close to it");
                powerEntered = scanner.nextInt();
            } catch (Exception e) {
                LOGGER.error("Input is wrong please type an integer type!!!",e);
                printToConsole("Input is wrong please type an integer type!!!");
                scanner.next();
                continue;
            }
            inputIsWrong = false;
        }
        return powerEntered;
    }

    public Location requestForLocationInput() {
        int selectedLocationId = 0;
        boolean inputIsWrong = true;
        while (inputIsWrong) {
            try {
                printToConsole("Select the device location fromm the list bellow");
                for (int i = 0; i < Location.values().length; i++) {
                    printToConsole((i + 1) + ". " + Location.values()[i].name());
                }
                printToConsole("enter an ID of Location from 1 to " + Location.values().length);
                selectedLocationId = scanner.nextInt();
            } catch (Exception e) {
                LOGGER.error("Input is wrong please type an integer type!!!",e);
                printToConsole("Input is wrong please type an integer type!!!");
                scanner.next();
                continue;
            }
            if (selectedLocationId > Location.values().length) {
                printToConsole("Please enter a number within a range (0-" + Location.values().length + ")");
            }
            inputIsWrong = false;
        }
        return Location.values()[selectedLocationId - 1];
    }


    public boolean requestForEnergizing() {
        boolean answer = false;
        boolean doWhileCycle = true;
        while (doWhileCycle) {
            printToConsole("Does the device should be energized? Enter y or n");
            switch (scanner.next()) {
                case ("y"):
                    answer = true;
                    break;
                case ("n"):
                    answer = false;
                    break;
                default:
                    printToConsole("Please answer y(Y) or n(N), try again...");
                    continue;
            }
            doWhileCycle = false;
        }
        return answer;
    }

    /**
     * Methods provides the requesting dialog of the desired device ID
     *
     * @return selected ID
     */
    public String requestForId() {
        String selectedId = "";
        boolean doWhileCycle = true;
        while (doWhileCycle) {
            commandService.getAllDevices(storeService.getDevices());
            printToConsole("Input an ID of the device listed above:");
            selectedId = scanner.next();
            if (storeService.getDevices().containsKey(selectedId)) {
                return selectedId;
            } else {
                printToConsole("There is now such id, try again");
                continue;
            }
        }
        return selectedId;
    }
}
