package com.yokall;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void stringContainsChar() {
         boolean result = StringUtils.stringContainsChar("epjkrabmiusofzclt", 'm');

         assertTrue(result);
    }

    @Test
    void stringDoesNotContainChar() {
        boolean result = StringUtils.stringContainsChar("epjkrabmiusofzclt", 'v');

        assertFalse(result);
    }
}