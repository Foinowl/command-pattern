package org.example.consoleapp.command.factory;

import org.apache.log4j.Logger;
import org.example.consoleapp.command.Command;
import org.example.consoleapp.command.impl.DeviceSortCommand;
import org.example.consoleapp.command.impl.FindDeviceByPowerCommand;
import org.example.consoleapp.command.impl.FindDeviceByPowerLocalizationCommand;
import org.example.consoleapp.command.impl.FindDeviceByPowerLocalizationEnergizingCommand;
import org.example.consoleapp.command.impl.GetAllDevicesCommand;
import org.example.consoleapp.command.impl.PlugInDeviceCommand;
import org.example.consoleapp.command.impl.PowerCalculationCommand;
import org.example.consoleapp.command.impl.UndefinedCommand;
import org.example.consoleapp.service.MenuService;

public class CommandDefiner {
    private final Logger LOGGER = Logger.getLogger(CommandDefiner.class);

    private final MenuService menuService;

    private Command command;

    public CommandDefiner(final MenuService menuService) {
        this.menuService = menuService;
    }

    public Command getCommand(String commandId) {
        switch (commandId) {
            case ("1"):
                command = new GetAllDevicesCommand();
                break;
            case ("2"):
                command = new PlugInDeviceCommand(menuService.requestForId());
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
                command = new UndefinedCommand();
        }
        LOGGER.info(command.toString() + " selected");
        return command;
    }
}
