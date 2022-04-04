package org.example.consoleapp.command.impl;

import org.example.consoleapp.command.BaseCommand;
import org.example.consoleapp.command.Command;
import org.example.consoleapp.entity.Location;
import org.example.consoleapp.service.factory.ServiceFactory;

public class FindDeviceByPowerLocalizationEnergizingCommand extends BaseCommand implements Command {
    private int power;
    private Location location;
    private boolean energizing;

    public FindDeviceByPowerLocalizationEnergizingCommand(final int power, final Location location,
                                                          final boolean energizing) {
        this.power = power;
        this.location = location;
        this.energizing = energizing;
    }

    @Override
    public void execute() {
        System.out.println("Selected Location -> " + location.name());
        System.out.println("Energizing state -> " + energizing);
        System.out.println("Selected power -> " + power);

        ServiceFactory.getInstance().getCommandService()
            .sortByLocation(devices, location)
            .filterByEnergizing(ServiceFactory.getInstance().getCommandService().getDeviceMapsSortedByLocation(), energizing)
            .findByPower(ServiceFactory.getInstance().getCommandService().getDeviceMapsSortedByEnergizing(), power);

        if (ServiceFactory.getInstance().getCommandService().getDeviceWithClosestPower().getDeviceName() != null) {
            System.out.println("It was found the device on location " + location.name() + "energizing state " + energizing + " which has power closest to " + power);
            System.out.println("Device -> " + ServiceFactory.getInstance().getCommandService().getDeviceWithClosestPower().toString());
        } else {
            System.out.println("It was not found any device match requested parameters");
        }
    }

    @Override
    public String toString() {
        return "FindDeviceByPowerLocalizationEnergizingCommand";
    }
}
