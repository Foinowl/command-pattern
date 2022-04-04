package org.example.consoleapp.command.impl;

import org.example.consoleapp.command.BaseCommand;
import org.example.consoleapp.command.Command;
import org.example.consoleapp.entity.Location;
import org.example.consoleapp.service.factory.ServiceFactory;

public class FindDeviceByPowerLocalizationCommand extends BaseCommand implements Command {
    private int power;
    private Location location;

    public FindDeviceByPowerLocalizationCommand(int power, Location location) {
        this.power = power;
        this.location = location;
    }

    @Override
    public void execute() {
        System.out.println("Selected Location -> " + location.name());
        System.out.println("Selected power -> " + power);

        ServiceFactory.getInstance().getCommandService()
            .sortByLocation(devices, location)
            .findByPower(ServiceFactory.getInstance().getCommandService().getDeviceMapsSortedByLocation(), power);

        if (ServiceFactory.getInstance().getCommandService().getDeviceWithClosestPower().getDeviceName() != null) {
            System.out.println("It was found the device on location " + location.name() + " which has power closest to " + power);
            System.out.println("Device -> " + ServiceFactory.getInstance().getCommandService().getDeviceWithClosestPower().toString());
        } else {
            System.out.println("It was not found any device match requested parameters");
        }
    }

    @Override
    public String toString() {
        return "FindDeviceByPowerLocalizationCommand";
    }
}
