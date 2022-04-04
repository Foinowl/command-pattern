package org.example.consoleapp.command.impl;

import java.util.Map;
import org.example.consoleapp.command.BaseCommand;
import org.example.consoleapp.command.Command;
import org.example.consoleapp.service.factory.ServiceFactory;

public class GetAllDevicesCommand extends BaseCommand implements Command {
    @Override
    public void execute() {
        ServiceFactory.getInstance().getCommandService().getAllDevices(devices);
    }

    @Override
    public String toString() {
        return "GetAllDevicesCommand";
    }
}
