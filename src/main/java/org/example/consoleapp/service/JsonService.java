package org.example.consoleapp.service;

import java.util.ArrayList;
import org.example.consoleapp.command.Command;

public class JsonService {
    private final ArrayList<Command> devices;

    public JsonService() {
        devices = new ArrayList<>();
    }

    public ArrayList<Command> getListOfDevicesFromJsonFile() {
        return devices;
    }
}
