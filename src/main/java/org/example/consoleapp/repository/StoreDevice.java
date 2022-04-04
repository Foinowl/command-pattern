package org.example.consoleapp.repository;

import java.util.Collections;
import java.util.Map;
import org.example.consoleapp.entity.Device;

public class StoreDevice {
    private final Map<String, Device> devices;

    public StoreDevice(final Map<String, Device> devices) {
        this.devices = Collections.unmodifiableMap(devices);
    }

    public Map<String, Device> getDevices() {
        return devices;
    }
}
