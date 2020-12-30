package com.yokall.dayfourteen;

import java.util.ArrayList;
import java.util.List;

public class CombinationMaker {
    public static List<String> generateCombinations(String memLocation, List<Integer> floatingBits) {
        List<String> combinations = new ArrayList<>();

        double maxNumber = Math.pow(2, floatingBits.size());

        for (int i = 0; i < maxNumber; i++) {
            StringBuilder location = new StringBuilder(memLocation);

            String binaryString = BinaryCalculator.numberToBinary(i);

            String flags = binaryString.substring(binaryString.length() - floatingBits.size());

            for (int j = 0; j < flags.length(); j++) {
                location.setCharAt(floatingBits.get(j), flags.charAt(j));
            }

            combinations.add(location.toString());
        }

        return combinations;
    }
}
