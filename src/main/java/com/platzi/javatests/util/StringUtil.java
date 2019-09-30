package com.platzi.javatests.util;

public class StringUtil {

    public static String repeat(String str, int times) {
        if (times < 0) {
            throw new IllegalArgumentException("Times must be positive");
        }
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < times; i++) {
            result.append(str);
        }

        return String.valueOf(result);
    }

    public static boolean isEmpty(String str) {
        return str == null ? true : str.trim().equals("");
    }
}

