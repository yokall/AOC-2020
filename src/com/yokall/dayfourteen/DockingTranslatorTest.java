package com.yokall.dayfourteen;

import com.yokall.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DockingTranslatorTest {

    private DockingTranslator dockingTranslator;

    @BeforeEach
    void setup() {
        dockingTranslator = new DockingTranslator();
    }

    @Test
    void sumMemoryValues() {
        double actual = dockingTranslator.sumMemoryValues(FileUtils.readLinesToArray("input/DayFourteenTest.txt"));

        assertEquals(165, actual);
    }
}