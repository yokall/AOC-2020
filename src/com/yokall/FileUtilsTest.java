package com.yokall;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
}