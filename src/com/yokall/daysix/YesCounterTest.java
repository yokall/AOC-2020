package com.yokall.daysix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YesCounterTest {

    YesCounter yesCounter;

    @BeforeEach
    void setUp() {
        yesCounter = new YesCounter();
    }

    @Test
    void countFromGroups() {
        int actual = yesCounter.countEachGroupYesAnswers("input/DaySixTest.txt");

        assertEquals(11, actual);
    }

    @Test
    void countFromEveryone() {
        int actual = yesCounter.countEveryoneYesAnswers("input/DaySixTest.txt");

        assertEquals(6, actual);
    }
}