package org.example.consoleapp.service.factory;

import java.util.Properties;
import org.example.consoleapp.service.CommandService;
import org.example.consoleapp.service.JsonService;
import org.example.consoleapp.service.MenuService;
import org.example.consoleapp.service.PropertyService;
import org.example.consoleapp.service.StoreService;

public class ServiceFactory {
    private final static ServiceFactory instance = new ServiceFactory();

    private final StoreService storeService;

    private final MenuService menuService;

    private final CommandService commandService;

    public ServiceFactory() {
        JsonService jsonService = new JsonService();
        this.menuService = new MenuService(
            new PropertyService(new Properties()),
            jsonService,
            new CommandService()
        );
        this.storeService = new StoreService(jsonService);
        this.commandService = new CommandService();
    }

    public StoreService getStoreService() {
        return storeService;
    }

    public MenuService getMenuService() {
        return menuService;
    }

    public CommandService getCommandService() {
        return commandService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
