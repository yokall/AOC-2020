package com.yokall.dayten;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdapterSorterOuter {
    private List<Integer> adapterRatings;

    public AdapterSorterOuter(List<Integer> unsortedAdapterRatings) {
        List<Integer> sortedAdapterRatings = new ArrayList<>(unsortedAdapterRatings);
        Collections.sort(sortedAdapterRatings);

        this.adapterRatings = sortedAdapterRatings;
    }

    public Long calculateAdapterDifference() {
        Long oneDifferenceCount = 0L;
        Long threeDifferenceCount = 0L;

        if (adapterRatings.get(0) == 1) {
            oneDifferenceCount++;
        }
        else if (adapterRatings.get(0) == 3) {
            threeDifferenceCount++;
        }

        for (int i = 1; i < adapterRatings.size(); i++) {
            int difference = adapterRatings.get(i) - adapterRatings.get(i -1);

            if (difference == 1L) {
                oneDifferenceCount++;
            }
            else if (difference == 3L) {
                threeDifferenceCount++;
            }
        }

        threeDifferenceCount++;

        return oneDifferenceCount * threeDifferenceCount;
    }

    public int calculateCombinations() {
        int numberOfCombinations = 0;

        for (int i = 1; i <= adapterRatings.get(adapterRatings.size()-1); i += 3) {
            System.out.println(i);

            if (adapterRatings.contains(i + 1)) {
                ++numberOfCombinations;
            }

            if (adapterRatings.contains(i + 2)) {
                ++numberOfCombinations;
            }

            if (adapterRatings.contains(i + 1) || adapterRatings.contains(i + 2)) {
                ++numberOfCombinations;
            }
        }

        return numberOfCombinations;
    }
}
