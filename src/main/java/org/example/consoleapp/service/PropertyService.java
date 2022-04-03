package org.example.consoleapp.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyService {
    private final Properties properties;

    public PropertyService(final Properties properties) {
        this.properties = properties;
    }

    public Properties readFromPropertiesFile(String fileName) {

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
