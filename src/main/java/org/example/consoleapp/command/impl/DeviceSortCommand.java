package org.example.consoleapp.command.impl;

import org.example.consoleapp.command.BaseCommand;
import org.example.consoleapp.command.Command;

public class DeviceSortCommand extends BaseCommand implements Command {
    @Override
    public void execute() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "DeviceSortCommand";
    }
}
