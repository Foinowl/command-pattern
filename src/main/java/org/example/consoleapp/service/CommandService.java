package org.example.consoleapp.service;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.example.consoleapp.entity.Device;
import org.example.consoleapp.entity.Location;

public class CommandService {
    private final SortedMap<Integer, String> resultMap;
    private final HashMap<String, Device> deviceMapsSortedByLocation;
    private Device deviceWithClosestPower;
    private final HashMap<String, Device> deviceMapsSortedByEnergizing;

    public CommandService() {
        resultMap = new TreeMap<>();
        deviceMapsSortedByLocation = new HashMap<>();
        deviceWithClosestPower = new Device();
        deviceMapsSortedByEnergizing = new HashMap<>();
    }

    public SortedMap<Integer, String> getResultMap() {
        return resultMap;
    }

    public HashMap<String, Device> getDeviceMapsSortedByLocation() {
        return deviceMapsSortedByLocation;
    }

    public Device getDeviceWithClosestPower() {
        return deviceWithClosestPower;
    }

    public HashMap<String, Device> getDeviceMapsSortedByEnergizing() {
        return deviceMapsSortedByEnergizing;
    }


    public CommandService findByPower(Map<String, Device> deviceMap, int power) {
        resultMap.clear();
        for (Map.Entry entry : deviceMap.entrySet()) {
            //iterating within whole power consumption rates of all devices and subtracting the selected power and rated power
            int diff = Math.abs(((Device) entry.getValue()).getPowerConsumption() - power);
            //storing in sorted map -> result of subtract(less value is closet value to selected power) put as key,
            // key of deviceHashMap put to value
            resultMap.put(diff, ((String) entry.getKey()));
        }
        if (!resultMap.isEmpty()) {
            deviceWithClosestPower = deviceMap.get(resultMap.values().toArray()[0]);
        }
        return this;
    }

    public CommandService sortByLocation(Map<String, Device> deviceMap, Location location) {
        deviceMapsSortedByLocation.clear();
        for (Map.Entry entry : deviceMap.entrySet()) {
            if (((Device) entry.getValue()).getLocation().name().equalsIgnoreCase(location.name())) {
                deviceMapsSortedByLocation.put(((String) entry.getKey()), ((Device) entry.getValue()));
            }
            deviceMapsSortedByLocation.forEach((K, V) -> {
                System.out.println("deviceMapsSortedByLocation " + K + " " + V);
            });
        }
        return this;
    }

    public CommandService sortByEnergizing(Map<String, Device> deviceMap, boolean energizingState) {
        deviceMapsSortedByEnergizing.clear();
        for (Map.Entry entry : deviceMap.entrySet()) {
            if (energizingState) {
                if (((Device) entry.getValue()).isEnergized()) {
                    deviceMapsSortedByEnergizing.put(((String) entry.getKey()), ((Device) entry.getValue()));
                }
            } else {
                if (!((Device) entry.getValue()).isEnergized()) {
                    deviceMapsSortedByEnergizing.put(((String) entry.getKey()), ((Device) entry.getValue()));
                }
            }
        }
        deviceMapsSortedByEnergizing.forEach((K, V) -> {
            System.out.println("deviceMapsSortedByEnergizing " + K + " " + V);
        });
        return this;
    }
}
