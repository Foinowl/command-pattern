package org.example.consoleapp.command.impl;

import java.util.Map;
import org.example.consoleapp.command.BaseCommand;
import org.example.consoleapp.command.Command;

public class GetAllDevicesCommand extends BaseCommand implements Command {
    @Override
    public void execute() {
        for (Map.Entry entry : devices.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "GetAllDevicesCommand";
    }
}
