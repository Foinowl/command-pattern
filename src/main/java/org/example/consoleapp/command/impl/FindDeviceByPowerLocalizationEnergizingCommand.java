package org.example.consoleapp.command.impl;

import org.example.consoleapp.command.BaseCommand;
import org.example.consoleapp.command.Command;
import org.example.consoleapp.entity.Location;

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

    }
}
