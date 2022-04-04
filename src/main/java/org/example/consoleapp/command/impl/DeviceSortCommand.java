package org.example.consoleapp.command.impl;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.example.consoleapp.command.BaseCommand;
import org.example.consoleapp.command.Command;
import org.example.consoleapp.entity.Device;
import org.example.consoleapp.service.factory.ServiceFactory;

public class DeviceSortCommand extends BaseCommand implements Command {
    @Override
    public void execute() {
        ServiceFactory.getInstance().getCommandService().sortByPower(devices).forEach((K, V) ->
            System.out.println(K + " " + V));
    }

    @Override
    public String toString() {
        return "DeviceSortCommand";
    }
}
