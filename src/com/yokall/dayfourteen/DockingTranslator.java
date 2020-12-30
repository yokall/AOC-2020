package com.yokall.dayfourteen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DockingTranslator {
    private HashMap<Double, Double> memory;
    private String mask;

    public DockingTranslator() {
        memory = new HashMap<>();

        mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    }

    public double sumMemoryValues(List<String> instructions) {
        Pattern memAllocPattern = Pattern.compile("mem\\[(\\d+)] = (\\d+)");

        for (String instruction : instructions) {
            Matcher matcher = memAllocPattern.matcher(instruction);

            if (matcher.find()) {
                double memLocation = Double.parseDouble(matcher.group(1));
                double memValue = Double.parseDouble(matcher.group(2));

                String binaryString = BinaryCalculator.numberToBinary(memValue);

                binaryString = applyMask(binaryString);

                memory.put(memLocation, BinaryCalculator.binaryToNumber(binaryString));
            } else {
                mask = instruction.substring(7);
            }
        }

        return getMemorySum();
    }

    public double sumMemoryValuesV2(List<String> instructions) {
        Pattern memAllocPattern = Pattern.compile("mem\\[(\\d+)] = (\\d+)");

        for (String instruction : instructions) {
            Matcher matcher = memAllocPattern.matcher(instruction);

            if (matcher.find()) {
                double memLocation = Double.parseDouble(matcher.group(1));
                double memValue = Double.parseDouble(matcher.group(2));

                String binaryString = BinaryCalculator.numberToBinary(memLocation);

                List<Double> memAddresses = applyMemMask(binaryString);

                for (Double memAddress : memAddresses) {
                    memory.put(memAddress, memValue);
                }
            } else {
                mask = instruction.substring(7);
            }
        }

        return getMemorySum();
    }

    private List<Double> applyMemMask(String binaryString) {
        List<Double> memAddresses = new ArrayList<>();

        List<Integer> xIndexes = new ArrayList<>();
        StringBuilder maskedString = new StringBuilder(binaryString);

        for (int i = 0; i < binaryString.length(); i++) {
            char maskChar = mask.charAt(i);

            if (maskChar != '0') {
                maskedString.setCharAt(i, maskChar);
            }

            if (maskChar == 'X') {
                xIndexes.add(i);
            }
        }

        List<String> memoryAddresses = CombinationMaker.generateCombinations(maskedString.toString(), xIndexes);

        for (String memoryAddress : memoryAddresses) {
            memAddresses.add(BinaryCalculator.binaryToNumber(memoryAddress));
        }

        return memAddresses;
    }

    private double getMemorySum() {
        double sum = 0;
        for (Double value : memory.values()) {
            sum += value;
        }
        return sum;
    }

    private String applyMask(String binaryString) {
        StringBuilder maskedString = new StringBuilder(binaryString);

        for (int i = 0; i < binaryString.length(); i++) {
            char c = mask.charAt(i);
            if (mask.charAt(i) != 'X') {
                maskedString.setCharAt(i, mask.charAt(i));
            }
        }

        return maskedString.toString();
    }
}
