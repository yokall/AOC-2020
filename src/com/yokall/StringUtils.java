package com.yokall;

public class StringUtils {
    public static boolean stringContainsChar(String string, char searchChar) {
        return string.indexOf(searchChar) != -1;
    }
}
