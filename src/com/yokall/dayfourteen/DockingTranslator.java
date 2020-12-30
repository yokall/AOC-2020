package com.yokall.dayfourteen;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DockingTranslator {
    private HashMap<Integer, Double> memory;
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
                int memLocation = Integer.parseInt(matcher.group(1));
                double memValue = Double.parseDouble(matcher.group(2));

                String binaryString = BinaryCalculator.numberToBinary(memValue);

                binaryString = applyMask(binaryString);

                memory.put(memLocation, BinaryCalculator.binaryToNumber(binaryString));
            }
            else {
                mask = instruction.substring(7);
            }
        }

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
