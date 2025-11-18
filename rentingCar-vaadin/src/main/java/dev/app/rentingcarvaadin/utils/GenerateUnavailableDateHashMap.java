package dev.app.rentingcarvaadin.utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class GenerateUnavailableDateHashMap {

    public static Map<Long, Boolean> generateHashMap() {

        LocalDate initialDate = LocalDate.of(2026, 1,1);
        LocalDate finalDate = LocalDate.of(2026, 12, 31);

        Map<Long, Boolean> oneYearDatesHashMap = new HashMap<>();

        for (LocalDate date = initialDate; !date.isAfter(finalDate); date = date.plusDays(1)) {

            oneYearDatesHashMap.put(date.toEpochDay(), true);
        }

        return oneYearDatesHashMap;
    }
}
