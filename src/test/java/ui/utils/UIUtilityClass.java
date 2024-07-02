package ui.utils;

import java.util.Random;

public class UIUtilityClass {

    public static int generateUniqueRandomNumber() {
        Random random = new Random();
        int min = 10000000;
        int max = 99999999;
        int randomNumber = random.nextInt(max - min + 1) + min;

        return randomNumber;
    }

}
