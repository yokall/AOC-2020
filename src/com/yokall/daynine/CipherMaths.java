package com.yokall.daynine;

import java.util.ArrayList;
import java.util.List;

public class CipherMaths {
    public static List<Long> allSums(List<Long> numbers, int startIndex, int endIndex) {
        List<Long> sums = new ArrayList<>();

        for (int i = startIndex; i < endIndex; i++) {
            for (int j = i + 1; j <= endIndex; j++) {
                sums.add(numbers.get(i) + numbers.get(j));
            }
        }

        return sums;
    }
}
