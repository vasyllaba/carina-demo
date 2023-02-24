package com.qaprosoft.carina.demo.utils;

import java.util.Random;

public class StringGenerator {
    public static String generateLogin() {
        return "TesterUser" + generate();
    }

    public static String generateEmail() {
        return generateLogin() + "@gmail.com";
    }

    private static String generate() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
