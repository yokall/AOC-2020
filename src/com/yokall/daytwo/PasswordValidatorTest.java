package com.yokall.daytwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PasswordValidatorTest {
    PasswordValidator passwordValidator;

    @BeforeEach
    void setUp() {
        passwordValidator = new PasswordValidator();
    }

    @Test
    void validatePasswordsPartOne() {
        List<String> input = new ArrayList<>(
                List.of(
                        "1-3 a: abcde",
                        "1-3 b: cdefg",
                        "2-9 c: ccccccccc"
                )
        );

        int actual = passwordValidator.validatePasswordsPartOne(input);

        Assertions.assertEquals(2, actual);
    }

    @Test
    void validatePasswordsPartTwo() {
        List<String> input = new ArrayList<>(
                List.of(
                        "1-3 a: abcde",
                        "1-3 b: cdefg",
                        "2-9 c: ccccccccc"
                )
        );

        int actual = passwordValidator.validatePasswordsPartTwo(input);

        Assertions.assertEquals(1, actual);
    }
}