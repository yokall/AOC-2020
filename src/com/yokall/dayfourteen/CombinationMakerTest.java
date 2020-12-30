package com.yokall.dayfourteen;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationMakerTest {

    @Test
    void generateCombinations() {
        List<Integer> floatingBits = new ArrayList<>();
        floatingBits.add(30);
        floatingBits.add(35);

        List<String> actual = CombinationMaker.generateCombinations("000000000000000000000000000000X1101X", floatingBits);

        List<String> expected = new ArrayList<>();
        expected.add("000000000000000000000000000000011010");
        expected.add("000000000000000000000000000000011011");
        expected.add("000000000000000000000000000000111010");
        expected.add("000000000000000000000000000000111011");

        assertEquals(expected, actual);
    }
}