package com.yokall.dayfour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    String value;
    int lowerBound;
    int upperBound;

    @BeforeEach
    void setUp() {
        lowerBound = 12;
        upperBound = 20;
    }

    @Test
    void validIntRange() {
        value = "15";

        boolean actual = Validator.stringIsValidIntRange(value, lowerBound, upperBound);

        Assertions.assertTrue(actual);
    }

    @Test
    void tooLowIntRange() {
        value = "10";

        boolean actual = Validator.stringIsValidIntRange(value, lowerBound, upperBound);

        Assertions.assertFalse(actual);
    }

    @Test
    void tooHighIntRange() {
        value = "30";

        boolean actual = Validator.stringIsValidIntRange(value, lowerBound, upperBound);

        Assertions.assertFalse(actual);
    }

    @Test
    void validateHeightCm() {
        value = "160cm";

        boolean actual = Validator.heightIsValid(value);

        Assertions.assertTrue(actual);
    }

    @Test
    void validateHeightIn() {
        value = "70in";

        boolean actual = Validator.heightIsValid(value);

        Assertions.assertTrue(actual);
    }

    @Test
    void validColour() {
        value = "#123abc";

        boolean actual = Validator.colourIsValid(value);

        assertTrue(actual);
    }

    @Test
    void invalidColour() {
        value = "#123abz";

        boolean actual = Validator.colourIsValid(value);

        assertFalse(actual);
    }
}