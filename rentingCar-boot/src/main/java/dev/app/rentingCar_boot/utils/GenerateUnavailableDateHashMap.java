package dev.app.rentingCar_boot.utils;

import java.util.HashMap;
import java.util.Map;

public class GenerateUnavailableDateHashMap {

    public static Map<Integer, Boolean> generateHashMap() {

        Map<Integer, Boolean> oneYearDatesHashMap = new HashMap<>();

        for (int i = 1767268800; i <= 1798718400; i = i+86400) {

            oneYearDatesHashMap.put(i,true);
        }

        return oneYearDatesHashMap;
    }
}
