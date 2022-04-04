package org.example.consoleapp.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

public class PropertyService {
    private final Logger LOGGER = Logger.getLogger(PropertyService.class);
    private final Properties properties;

    public PropertyService(final Properties properties) {
        this.properties = properties;
    }

    public Properties readFromPropertiesFile(String fileName) {

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
            properties.load(inputStream);
        } catch (IOException e) {
            LOGGER.error("Exception: " + e);
            e.printStackTrace();
        }
        return properties;
    }
}
