package com.yokall.dayfour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassportCheckerTest {

    PassportChecker passportChecker;

    @BeforeEach
    void setUp() {
        passportChecker = new PassportChecker();
    }

    @Test
    void partOne() {
        int actual = passportChecker.checkPassports("DayFourTest.txt", false);

        Assertions.assertEquals(2, actual);
    }
}