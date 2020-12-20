package com.yokall.dayten;

import com.yokall.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdapterSorterOuterTest {

    private AdapterSorterOuter adapterSorterOuter;

    @BeforeEach
    void setUp() {
        adapterSorterOuter = new AdapterSorterOuter(FileUtils.readLinesToIntegerArray("input/DayTenTest.txt"));
    }

    @Test
    void calculateAdapterDifference() {
        Long actual = adapterSorterOuter.calculateAdapterDifference();

        assertEquals(35L, actual);
    }

    @Test
    void calculateCombinations() {
        int numberOfCombinations = adapterSorterOuter.calculateCombinations();

        assertEquals(8, numberOfCombinations);
    }
}