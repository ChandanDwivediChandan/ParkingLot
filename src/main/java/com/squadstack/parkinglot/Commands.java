package com.squadstack.parkinglot;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.HashMap;
public class Commands {
    public Map<String, Method> commandsMap;

    public Commands() {
        commandsMap = new HashMap<String, Method>();
        try {
            populateCommandsHashMap();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    private void populateCommandsHashMap() throws NoSuchMethodException {
        commandsMap.put("create", ParkingLot.class.getMethod("createParkingLot", String.class));
        commandsMap.put("park", ParkingLot.class.getMethod("park", String.class, String.class));
        commandsMap.put("leave", ParkingLot.class.getMethod("leave", String.class));
        commandsMap.put("status", ParkingLot.class.getMethod("status"));
        commandsMap.put("reg_num_acc_to_age", ParkingLot.class.getMethod("getRegistrationNumbersFromAge", String.class));
        commandsMap.put("slot_num_acc_to_age", ParkingLot.class.getMethod("getSlotNumbersFromAge", String.class));
        commandsMap.put("slot_num_acc_to_reg_num", ParkingLot.class.getMethod("getSlotNumberFromRegNo", String.class));
    }
}
