package org.example.consoleapp.command.impl;

import org.example.consoleapp.command.BaseCommand;
import org.example.consoleapp.command.Command;
import org.example.consoleapp.service.factory.ServiceFactory;

public class FindDeviceByPowerCommand extends BaseCommand implements Command {
    private int power;

    public FindDeviceByPowerCommand(int power) {
        this.power = power;
    }

    @Override
    public void execute() {
        System.out.println("Selected power is => " + power);
        System.out.println("The nearest value of power to the selected power is for device: " +
            ServiceFactory.getInstance().getCommandService()
                .findByPower(devices, power).getDeviceWithClosestPower().toString());
    }

    @Override
    public String toString() {
        return "FindDeviceByPowerCommand";
    }
}
