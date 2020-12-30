package com.yokall.dayfourteen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryCalculatorTest {

    @Test
    void numberToBinary() {
        String actual = BinaryCalculator.numberToBinary(11);

        assertEquals("000000000000000000000000000000001011", actual);
    }

    @Test
    void binaryToNumber() {
        double actual = BinaryCalculator.binaryToNumber("000000000000000000000000000000001011");

        assertEquals(11, actual);
    }
}