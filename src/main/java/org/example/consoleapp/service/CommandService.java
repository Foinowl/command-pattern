package org.example.consoleapp.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import org.example.consoleapp.entity.Device;
import org.example.consoleapp.entity.Location;
import org.example.consoleapp.service.factory.ServiceFactory;

public class CommandService {
    private final SortedMap<Integer, String> resultMap;
    private final Map<String, Device> deviceMapsSortedByLocation;
    private final Map<String, Device> deviceMapsSortedByEnergizing;
    private final Map<String, Device> deviceMapSortedById;
    private Device deviceWithClosestPower;
    private Device device;

    public CommandService() {
        resultMap = new TreeMap<>();
        deviceMapsSortedByLocation = new HashMap<>();
        deviceWithClosestPower = new Device();
        deviceMapsSortedByEnergizing = new HashMap<>();
        deviceMapSortedById = new HashMap<>();
        device = new Device();
    }

    public SortedMap<Integer, String> getResultMap() {
        return resultMap;
    }

    public Map<String, Device> getDeviceMapsSortedByLocation() {
        return deviceMapsSortedByLocation;
    }

    public Device getDeviceWithClosestPower() {
        return deviceWithClosestPower;
    }

    public Map<String, Device> getDeviceMapsSortedByEnergizing() {
        return deviceMapsSortedByEnergizing;
    }


    public Device findByPower(Map<String, Device> deviceHashMap, Integer power) {
        resultMap.clear();
        for (Map.Entry entry : deviceHashMap.entrySet()) {
            //iterating within whole power consumption rates of all devices and subtracting the selected power and rated power
            int diff = Math.abs(((Device) entry.getValue()).getPowerConsumption() - power);
            //storing in sorted map -> result of subtract(less value is closet value to selected power) put as key,
            // key of deviceHashMap put to value
            resultMap.put(diff, ((String) entry.getKey()));
        }
        return deviceHashMap.get(resultMap.values().toArray()[0]);
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

    public CommandService filterByEnergizing(Map<String, Device> deviceMap, boolean energizingState) {
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

    public void getAllDevices(Map<String, Device> deviceHashMap) {
        deviceHashMap.forEach((K, V) -> {
            System.out.println(K + " " + V);
        });
    }

    public Map<String, Device> plugInDevice(Map<String, Device> deviceMap, String id) {
        Map<String, Device> devices = Map.copyOf(deviceMap);
        for (Map.Entry entry : devices.entrySet()) {
            if (((String) entry.getKey()).contentEquals(id)) {
                device = ((Device) entry.getValue());
                device.setEnergized(true);
            }
        }
        ServiceFactory.getInstance().getCommandService().getAllDevices(deviceMap);
        return deviceMap;
    }

    public Integer powerCalculation(Map<String, Device> deviceHashMap) {
        int totalPowerCalculated = 0;
        for (Map.Entry entry : deviceHashMap.entrySet()) {
            if (((Device) entry.getValue()).isEnergized()) {
                totalPowerCalculated = totalPowerCalculated + ((Device) entry.getValue()).getPowerConsumption();
            }
        }
        return totalPowerCalculated;
    }

    public Map<String, Device> sortByPower(Map<String, Device> deviceHashMap) {
        Comparator<HashMap.Entry<String, Device>> valueComparator =
            Comparator.comparingInt(e -> e.getValue().getPowerConsumption());
        HashMap<String, Device> sortedMap =
            deviceHashMap.entrySet().stream().
                sorted(valueComparator).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                    (e1, e2) -> e1, LinkedHashMap::new));
        return sortedMap;
    }
}
