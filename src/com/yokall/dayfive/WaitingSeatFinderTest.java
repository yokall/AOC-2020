package com.yokall.dayfive;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WaitingSeatFinderTest {
    SeatFinder seatFinder;

    @BeforeEach
    void setUp() {
        seatFinder = new SeatFinder();
    }

    @ParameterizedTest
    @CsvSource({"FBFBBFFRLR,357", "BFFFBBFRRR,567", "FFFBBBFRRR,119", "BBFFBBFRLL,820"})
    void seatIdExampleOne(String seatReference, String expected) {
        int actual = seatFinder.findSeatId(seatReference);

        assertEquals(Integer.valueOf(expected), actual);
    }
}