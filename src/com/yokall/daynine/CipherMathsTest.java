package com.yokall.daynine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CipherMathsTest {

    private List<Long> numbers;


    @BeforeEach
    void setup() {
        numbers = new ArrayList<>();

        numbers.add(35L);
        numbers.add(20L);
        numbers.add(15L);
        numbers.add(25L);
        numbers.add(47L);
        numbers.add(40L);
        numbers.add(62L);
        numbers.add(55L);
        numbers.add(65L);
        numbers.add(95L);
        numbers.add(102L);
        numbers.add(117L);
        numbers.add(150L);
        numbers.add(182L);
        numbers.add(127L);
        numbers.add(219L);
        numbers.add(299L);
        numbers.add(277L);
        numbers.add(309L);
        numbers.add(576L);
    }

    @Test
    void allSums() {
        List<Long> actual = CipherMaths.allSums(numbers, 0, 4);

        List<Long> expected = new ArrayList<>();
        expected.add(55L);
        expected.add(50L);
        expected.add(60L);
        expected.add(82L);

        expected.add(35L);
        expected.add(45L);
        expected.add(67L);

        expected.add(40L);
        expected.add(62L);

        expected.add(72L);

        assertEquals(expected, actual);
    }
}