package org.example.consoleapp.command.impl;

import org.example.consoleapp.command.BaseCommand;
import org.example.consoleapp.command.Command;
import org.example.consoleapp.service.factory.ServiceFactory;

public class PowerCalculationCommand extends BaseCommand implements Command {
    @Override
    public void execute() {
        System.out.println("The total power consumption of all energized devices is -> " +
            ServiceFactory.getInstance().getCommandService().powerCalculation(devices));
    }

    @Override
    public String toString() {
        return "PowerCalculationCommand";
    }
}
