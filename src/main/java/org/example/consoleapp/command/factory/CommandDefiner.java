package org.example.consoleapp.command.factory;

import org.example.consoleapp.command.Command;
import org.example.consoleapp.command.impl.DeviceSortCommand;
import org.example.consoleapp.command.impl.FindDeviceByPowerCommand;
import org.example.consoleapp.command.impl.FindDeviceByPowerLocalizationCommand;
import org.example.consoleapp.command.impl.FindDeviceByPowerLocalizationEnergizingCommand;
import org.example.consoleapp.command.impl.GetAllDevicesCommand;
import org.example.consoleapp.command.impl.PlugInDeviceCommand;
import org.example.consoleapp.command.impl.PowerCalculationCommand;
import org.example.consoleapp.service.MenuService;
import org.example.consoleapp.service.factory.ServiceFactory;

public class CommandDefiner {
    private static final CommandDefiner instance = new CommandDefiner();
    private Command command;
    private MenuService menuService = ServiceFactory.getInstance().getMenuService();

    public CommandDefiner() {
    }

    public static CommandDefiner getInstance() {
        return instance;
    }

    public Command getCommand(String commandId) {
        switch (commandId) {
            case ("1"):
                command = new GetAllDevicesCommand();
                break;
            case ("2"):
                command = new PlugInDeviceCommand();
                break;
            case ("3"):
                command = new PowerCalculationCommand();
                break;
            case ("4"):
                command = new DeviceSortCommand();
                break;
            case ("5"):
                command = new FindDeviceByPowerCommand(menuService.requestForPowerInput());
                break;
            case ("6"):
                command = new FindDeviceByPowerLocalizationCommand(
                    menuService.requestForPowerInput(),
                    menuService.requestForLocationInput());
                break;
            case ("7"):
                command = new FindDeviceByPowerLocalizationEnergizingCommand(
                    menuService.requestForPowerInput(),
                    menuService.requestForLocationInput(),
                    menuService.requestForEnergizing());
                break;
            default:
                System.out.println("There is not found such command with id - " + commandId);
        }
        return command;
    }
}
