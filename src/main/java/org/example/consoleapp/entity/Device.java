package org.example.consoleapp.entity;

public class Device {
    private String deviceName;
    private Location location;
    private int powerConsumption;
    private boolean energized;

    public Device(final String deviceName, final Location location, final int powerConsumption,
                  final boolean energized) {
        this.deviceName = deviceName;
        this.location = location;
        this.powerConsumption = powerConsumption;
        this.energized = energized;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(final String deviceName) {
        this.deviceName = deviceName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(final Location location) {
        this.location = location;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(final int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public boolean isEnergized() {
        return energized;
    }

    public void setEnergized(final boolean energized) {
        this.energized = energized;
    }

    @Override
    public String toString() {
        return "Device{" +
            "deviceName='" + deviceName + '\'' +
            ", location=" + location +
            ", powerConsumption=" + powerConsumption +
            ", energized=" + energized +
            '}';
    }
}
