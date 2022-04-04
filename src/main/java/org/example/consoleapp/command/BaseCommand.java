package org.example.consoleapp.command;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.consoleapp.entity.Device;
import org.example.consoleapp.service.factory.ServiceFactory;

public abstract class BaseCommand {
    protected Map<String, Device> devices = Collections.unmodifiableMap(ServiceFactory.getInstance().getJsonService().getListOfDevicesFromJsonFile());
}
