package org.example.consoleapp.command;

import java.util.Collections;
import java.util.Map;
import org.apache.log4j.Logger;
import org.example.consoleapp.entity.Device;
import org.example.consoleapp.service.factory.ServiceFactory;

public abstract class BaseCommand {
    protected static final Logger LOGGER = Logger.getLogger(BaseCommand.class);

    protected Map<String, Device> devices = Collections.unmodifiableMap(ServiceFactory.getInstance().getStoreService().getDevices());
}
