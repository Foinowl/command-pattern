package org.example.consoleapp.service.factory;

import java.util.Properties;
import org.example.consoleapp.service.MenuService;
import org.example.consoleapp.service.PropertyService;

public class ServiceFactory {
    private final static ServiceFactory instance = new ServiceFactory();
    private final MenuService menuService;
    private final PropertyService propertyService;

    public ServiceFactory() {
        this.menuService = new MenuService();
        this.propertyService = new PropertyService(new Properties());
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public MenuService getMenuService() {
        return menuService;
    }

    public PropertyService getPropertyService() {
        return propertyService;
    }
}
