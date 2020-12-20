package com.yokall.daynine;

import com.yokall.FileUtils;

import java.util.List;

public class CipherChecker {
    private List<Long> numbers;

    public CipherChecker(String input) {
        numbers = FileUtils.readLinesToNumberArray(input);
    }

    public Long findInvalidNumber(int preambleSize) {
        int startIndex = 0;

        int endIndex = preambleSize -1;

        List<Long> sums = CipherMaths.allSums(numbers, startIndex, endIndex);

        for (int i = preambleSize; i < numbers.size(); i++) {
            if (!sums.contains(numbers.get(i)))   {
                return numbers.get(i);
            }

            ++startIndex;
            ++endIndex;

            sums = CipherMaths.allSums(numbers, startIndex, endIndex);
        }

        return -1L;
    }

    public Long findContiguousSum(long sumTarget) {
        Long sum;

        int lowestNumberIndex;
        int highestNumberIndex;

        for (int i = 0; i < numbers.size() - 1; i++) {
            sum = numbers.get(i);

            lowestNumberIndex = i;
            highestNumberIndex = i;

            for (int j = i + 1; j < numbers.size(); j++) {
                sum += numbers.get(j);

                if (numbers.get(j) > numbers.get(highestNumberIndex)) {
                    highestNumberIndex = j;
                }
                else if (numbers.get(j) < numbers.get(lowestNumberIndex)) {
                    lowestNumberIndex = j;
                }

                if (sum > sumTarget) {
                    break;
                }

                if (sum == sumTarget) {
                    return numbers.get(lowestNumberIndex) + numbers.get(highestNumberIndex);
                }
            }

        }

        return null;
    }
}
