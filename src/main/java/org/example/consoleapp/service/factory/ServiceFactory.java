package org.example.consoleapp.service.factory;

import java.util.Properties;
import org.example.consoleapp.service.CommandService;
import org.example.consoleapp.service.JsonService;
import org.example.consoleapp.service.MenuService;
import org.example.consoleapp.service.PropertyService;

public class ServiceFactory {
    private final static ServiceFactory instance = new ServiceFactory();

    private final MenuService menuService;

    private final PropertyService propertyService;

    private final JsonService jsonService;

    private final CommandService commandService;

    public ServiceFactory() {
        this.menuService = new MenuService();
        this.propertyService = new PropertyService(new Properties());
        this.jsonService = new JsonService();
        this.commandService = new CommandService();
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public MenuService getMenuService() {
        return menuService;
    }

    public JsonService getJsonService() {
        return jsonService;
    }

    public PropertyService getPropertyService() {
        return propertyService;
    }

    public CommandService getCommandService() {
        return commandService;
    }
}
