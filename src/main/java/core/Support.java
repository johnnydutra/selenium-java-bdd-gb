package core;

import org.apache.commons.lang3.RandomStringUtils;

public class Support {

    public static String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public static String generateRandomString(int length) {
        return RandomStringUtils.random(length);
    }
}
