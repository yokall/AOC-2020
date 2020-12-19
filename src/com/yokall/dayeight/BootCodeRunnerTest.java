package com.yokall.dayeight;

import com.yokall.FileUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BootCodeRunnerTest {
    @Test
    void safeRunInstructions() {
        BootCodeRunner bootCodeRunner = new BootCodeRunner(FileUtils.readLinesToArray("input/DayEightTest.txt"));

        boolean ranSuccessfully = bootCodeRunner.safeRunInstructions();

        assertEquals(5, bootCodeRunner.getAccumulator());

        assertFalse(ranSuccessfully);
    }
}