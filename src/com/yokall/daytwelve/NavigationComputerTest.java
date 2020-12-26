package com.yokall.daytwelve;

import com.yokall.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NavigationComputerTest {

    NavigationComputer navigationComputer;

    @BeforeEach
    void setUp() {
        navigationComputer = new NavigationComputer(FileUtils.readLinesToArray("input/DayTwelveTest.txt"));
    }

    @Test
    void runInstructions() {
        int actual = navigationComputer.runInstructions();

        assertEquals(25, actual);
    }

    @Test
    void runInstructionsTwo() {
        int actual = navigationComputer.runInstructionsTwo();

        assertEquals(286, actual);
    }
}