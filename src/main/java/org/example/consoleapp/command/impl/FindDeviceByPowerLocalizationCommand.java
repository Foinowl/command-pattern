package org.example.consoleapp.command.impl;

import org.example.consoleapp.command.BaseCommand;
import org.example.consoleapp.command.Command;
import org.example.consoleapp.entity.Location;

public class FindDeviceByPowerLocalizationCommand extends BaseCommand implements Command {
    private int power;
    private Location location;

    public FindDeviceByPowerLocalizationCommand(int power, Location location) {
        this.power = power;
        this.location = location;
    }

    @Override
    public void execute() {

    }
}
