package com.yokall.dayfour;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean stringIsValidIntRange(String value, int lowerBound, int upperBound) {
        try {
            int intValue = Integer.parseInt(value);

            if (intValue < lowerBound || intValue > upperBound) {
                return false;
            }
        } catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }

    public static boolean heightIsValid(String value) {
        String size = value.substring(0, value.length() - 2);
        String unitOfMeasurement = value.substring(value.length() - 2);

        if (unitOfMeasurement.equals("cm")) {
            return stringIsValidIntRange(size, 150, 193);
        } else if (unitOfMeasurement.equals("in")) {
            return stringIsValidIntRange(size, 59, 76);
        } else {
            return false;
        }
    }

    public static boolean colourIsValid(String value) {
        Pattern regex = Pattern.compile("^#[0-9a-f]{6}$");

        Matcher matcher = regex.matcher(value);

        return matcher.find();
    }

    public static boolean eyeColourIsValid(String value) {
        return value.equals("amb")
                || value.equals("blu")
                || value.equals("brn")
                || value.equals("gry")
                || value.equals("grn")
                || value.equals("hzl")
                || value.equals("oth");
    }

    public static boolean passportIDIsValid(String value) {
        Pattern regex = Pattern.compile("^\\d{9}$");

        Matcher matcher = regex.matcher(value);

        return matcher.find();
    }
}
