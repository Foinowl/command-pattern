package org.example.consoleapp.service;

import java.util.Map;
import org.example.consoleapp.entity.Device;
import org.example.consoleapp.repository.StoreDevice;

public class StoreService {

    private final StoreDevice storeDevice;

    private final JsonService jsonService;

    public StoreService(final JsonService jsonService) {
        this.jsonService = jsonService;
        this.storeDevice = new StoreDevice(this.jsonService.getListOfDevicesFromJsonFile());
    }

    public void storeMapToJson(Map<String, Device> deviceMap) {
        jsonService.storeMapToJson(deviceMap);
    }

    public Map<String, Device> getDevices() {
        return storeDevice.getDevices();
    }
}
