package org.example.consoleapp.command.impl;

import org.example.consoleapp.command.BaseCommand;
import org.example.consoleapp.command.Command;

public class FindDeviceByPowerCommand extends BaseCommand implements Command {
    private int power;

    public FindDeviceByPowerCommand(int power) {
        this.power = power;
    }

    @Override
    public void execute() {

    }
}
