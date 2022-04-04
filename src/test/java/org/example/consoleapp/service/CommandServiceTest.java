package org.example.consoleapp.service;

import java.util.HashMap;
import java.util.Map;
import org.example.consoleapp.entity.Device;
import org.example.consoleapp.entity.Location;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CommandServiceTest {
    private static Map<String, Device> inputMap;
    private static CommandService commandService;

    @BeforeAll
    public static void setUp() {
        inputMap = new HashMap<>();
        commandService = new CommandService();
    }

    @Test
    public void testFindByPower() {
        //GIVEN
        int inputData = 3550;
        inputMap.put("1", new Device("first", Location.BED_ROOM, 2000, true));
        inputMap.put("2", new Device("second", Location.BED_ROOM, 3000, true));
        inputMap.put("3", new Device("third", Location.BED_ROOM, 4000, true));
        Device expectedResult = commandService.findByPower(inputMap, inputData);
        System.out.println("expectedResult->" + expectedResult);

        //WHEN
        Device myResult = new Device("third", Location.BED_ROOM, 4000, true);
        System.out.println("myResult->" + myResult);

        //THEN
        Assert.assertEquals(expectedResult, myResult);
    }

    @Test
    void testPlugInDevice() {
        //GIVEN
        inputMap.put("1", new Device("first", Location.BED_ROOM, 2000, false));

        //THEN
        Assert.assertEquals(commandService.plugInDevice(inputMap, "1").get("1").isEnergized(), true);

    }

    @Test
    void testPowerCalculation() {
        //GIVEN
        inputMap.put("1", new Device("first", Location.BED_ROOM, 2000, true));
        inputMap.put("2", new Device("second", Location.BED_ROOM, 3000, true));
        //THEN
        Assert.assertTrue(commandService.powerCalculation(inputMap) == 5000);
    }
}