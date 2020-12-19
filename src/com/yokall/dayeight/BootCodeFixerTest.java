package com.yokall.dayeight;

import com.yokall.FileUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BootCodeFixerTest {
    @Test
    void fixBootInstructions() {
        BootCodeFixer bootCodeFixer = new BootCodeFixer();

        int fixedAccumulator = bootCodeFixer.fixBootInstructions(FileUtils.readLinesToArray("input/DayEightTest.txt"));

        assertEquals(8, fixedAccumulator);
    }
}