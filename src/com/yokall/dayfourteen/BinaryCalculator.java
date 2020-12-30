package com.yokall.dayfourteen;

public class BinaryCalculator {
    public static String numberToBinary(double number) {
        StringBuilder result = new StringBuilder();

        while (number > 0) {
            int bit = (int) (number % 2);

            result.insert(0, bit);

            number = Math.floor(number / 2);
        }

        for (int i = result.length(); i < 36; i++) {
            result.insert(0, "0");
        }

        return result.toString();
    }

    public static double binaryToNumber(String binaryString) {
        double number = 0;

        StringBuilder reversedBinaryString = new StringBuilder(binaryString).reverse();

        for (int i = 0; i < reversedBinaryString.length(); i++) {
            int bit = Character.getNumericValue(reversedBinaryString.charAt(i));

            number += bit * Math.pow(2, i);
        }

        return number;
    }
}
