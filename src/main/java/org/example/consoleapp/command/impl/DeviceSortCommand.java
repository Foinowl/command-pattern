package org.example.consoleapp.command.impl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.example.consoleapp.command.BaseCommand;
import org.example.consoleapp.command.Command;
import org.example.consoleapp.entity.Device;

public class DeviceSortCommand extends BaseCommand implements Command {
    @Override
    public void execute() {
        Comparator<Map.Entry<String, Device>> comparator = Comparator.comparingInt(v -> v.getValue().getPowerConsumption());
        Map<String, Device> sortedDevices = devices
            .entrySet()
            .stream()
            .sorted(comparator)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (s1, s2) -> s1, LinkedHashMap::new));

        for (Map.Entry<String, Device> entry : sortedDevices.entrySet()) {
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "DeviceSortCommand";
    }
}
