package org.example.consoleapp.service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.consoleapp.entity.Device;

public class JsonService {
    private final static String NAME = ".//src//main//resources/devices.json";
    private final Gson gson;
    private final Path path;

    public JsonService() {
        this.gson = new Gson();
        this.path = Paths.get(NAME);
    }

    public Map<String, Device> getListOfDevicesFromJsonFile() {
        String fileContent = null;
        try {
            fileContent = new String(Files.readAllBytes(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson.fromJson(fileContent,
            new TypeToken<Map<String, Device>>(){}.getType()
        );
    }
}
