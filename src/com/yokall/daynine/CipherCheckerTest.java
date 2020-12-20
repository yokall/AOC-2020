package com.yokall.daynine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CipherCheckerTest {

    private CipherChecker cipherChecker;

    @BeforeEach
    void setUp() {
        cipherChecker = new CipherChecker("input/DayNineTest.txt");
    }

    @Test
    void findInvalidNumber() {
        Long actual = cipherChecker.findInvalidNumber(5);

        assertEquals(127L, actual);
    }



    @Test
    void findContiguosSum() {
        Long actual = cipherChecker.findContiguousSum(127L);

        assertEquals(62L, actual);
    }
}