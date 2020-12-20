package com.yokall;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileUtilsTest {

    @Test
    void readGroupsToArray() {
        ArrayList<String> groups = FileUtils.readGroupsToArray("input/DaySixTest.txt");

        ArrayList<String> expected = new ArrayList<>();
        expected.add("abc");
        expected.add("abc");
        expected.add("abac");
        expected.add("aaaa");
        expected.add("b");

        assertEquals(expected, groups);
    }

    @Test
    void readGroupsIndividualsToArray() {
        ArrayList<String> groups = FileUtils.readGroupsIndividualsToArray("input/DaySixTest.txt");

        ArrayList<String> expected = new ArrayList<>();
        expected.add("abc");
        expected.add("a,b,c");
        expected.add("ab,ac");
        expected.add("a,a,a,a");
        expected.add("b");

        assertEquals(expected, groups);
    }

    @Test
    void readLinesToNumberArray() {
        List<Long> actual = FileUtils.readLinesToNumberArray("input/DayNineTest.txt");

        List<Long> expected = new ArrayList<>();
        expected.add(35L);
        expected.add(20L);
        expected.add(15L);
        expected.add(25L);
        expected.add(47L);
        expected.add(40L);
        expected.add(62L);
        expected.add(55L);
        expected.add(65L);
        expected.add(95L);
        expected.add(102L);
        expected.add(117L);
        expected.add(150L);
        expected.add(182L);
        expected.add(127L);
        expected.add(219L);
        expected.add(299L);
        expected.add(277L);
        expected.add(309L);
        expected.add(576L);

        assertEquals(expected, actual);
    }
}