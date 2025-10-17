package dev.app.rentingCar_boot.utils;

import java.util.Random;

public class GenerateUuid {

    public static String generateUuid () {
        Random random = new Random();
        int uuid = 1000 + random.nextInt(9000);
        return String.valueOf(uuid);
    }
}
