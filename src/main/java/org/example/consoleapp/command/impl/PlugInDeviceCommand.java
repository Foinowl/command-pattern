package org.example.consoleapp.command.impl;

import org.example.consoleapp.command.BaseCommand;
import org.example.consoleapp.command.Command;
import org.example.consoleapp.service.factory.ServiceFactory;

public class PlugInDeviceCommand extends BaseCommand implements Command {
    private final String id;

    public PlugInDeviceCommand(String id) {
        this.id = id;
    }

    @Override
    public void execute() {
        System.out.println("Requested id -> " + id);
        ServiceFactory.getInstance().getStoreService().storeMapToJson(
            ServiceFactory.getInstance().getCommandService().plugInDevice(devices, id));
    }

    @Override
    public String toString() {
        return "PlugInDeviceCommand";
    }
}
