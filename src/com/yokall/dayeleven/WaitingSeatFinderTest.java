package com.yokall.dayeleven;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WaitingSeatFinderTest {

    @Test
    void getFloorPlan() {
        WaitingSeatFinder waitingSeatFinder = new WaitingSeatFinder("input/DayElevenTest0.txt");

        List<List<Character>> actual = waitingSeatFinder.getFloorPlan();

        List<List<Character>> expected = new ArrayList<>();

        List<Character> line1 = new ArrayList<>();
        line1.add('L');
        line1.add('.');
        line1.add('L');
        line1.add('L');
        line1.add('.');
        line1.add('L');
        line1.add('L');
        line1.add('.');
        line1.add('L');
        line1.add('L');

        List<Character> line2 = new ArrayList<>();
        line2.add('L');
        line2.add('L');
        line2.add('L');
        line2.add('L');
        line2.add('L');
        line2.add('L');
        line2.add('L');
        line2.add('.');
        line2.add('L');
        line2.add('L');

        List<Character> line3 = new ArrayList<>();
        line3.add('L');
        line3.add('.');
        line3.add('L');
        line3.add('.');
        line3.add('L');
        line3.add('.');
        line3.add('.');
        line3.add('L');
        line3.add('.');
        line3.add('.');

        List<Character> line4 = new ArrayList<>();
        line4.add('L');
        line4.add('L');
        line4.add('L');
        line4.add('L');
        line4.add('.');
        line4.add('L');
        line4.add('L');
        line4.add('.');
        line4.add('L');
        line4.add('L');

        List<Character> line5 = new ArrayList<>();
        line5.add('L');
        line5.add('.');
        line5.add('L');
        line5.add('L');
        line5.add('.');
        line5.add('L');
        line5.add('L');
        line5.add('.');
        line5.add('L');
        line5.add('L');

        List<Character> line6 = new ArrayList<>();
        line6.add('L');
        line6.add('.');
        line6.add('L');
        line6.add('L');
        line6.add('L');
        line6.add('L');
        line6.add('L');
        line6.add('.');
        line6.add('L');
        line6.add('L');

        List<Character> line7 = new ArrayList<>();
        line7.add('.');
        line7.add('.');
        line7.add('L');
        line7.add('.');
        line7.add('L');
        line7.add('.');
        line7.add('.');
        line7.add('.');
        line7.add('.');
        line7.add('.');

        List<Character> line8 = new ArrayList<>();
        line8.add('L');
        line8.add('L');
        line8.add('L');
        line8.add('L');
        line8.add('L');
        line8.add('L');
        line8.add('L');
        line8.add('L');
        line8.add('L');
        line8.add('L');

        List<Character> line9 = new ArrayList<>();
        line9.add('L');
        line9.add('.');
        line9.add('L');
        line9.add('L');
        line9.add('L');
        line9.add('L');
        line9.add('L');
        line9.add('L');
        line9.add('.');
        line9.add('L');

        List<Character> line10 = new ArrayList<>();
        line10.add('L');
        line10.add('.');
        line10.add('L');
        line10.add('L');
        line10.add('L');
        line10.add('L');
        line10.add('L');
        line10.add('.');
        line10.add('L');
        line10.add('L');

        expected.add(line1);
        expected.add(line2);
        expected.add(line3);
        expected.add(line4);
        expected.add(line5);
        expected.add(line6);
        expected.add(line7);
        expected.add(line8);
        expected.add(line9);
        expected.add(line10);

        assertEquals(expected, actual);
    }

    @Test
    void runRules() {
        WaitingSeatFinder waitingSeatFinderZero = new WaitingSeatFinder("input/DayElevenTest0.txt");

        boolean stabilised = waitingSeatFinderZero.runRules(false);

        assertFalse(stabilised);

        WaitingSeatFinder waitingSeatFinderOne = new WaitingSeatFinder("input/DayElevenTest1.txt");

        assertEquals(waitingSeatFinderOne.getFloorPlan(), waitingSeatFinderZero.getFloorPlan());
    }

    @Test
    void runRulesStabilised() {
        WaitingSeatFinder waitingSeatFinder = new WaitingSeatFinder("input/DayElevenTest3.txt");

        boolean stabilised = waitingSeatFinder.runRules(false);

        assertTrue(stabilised);
    }

    @Test
    void countSeats() {
        WaitingSeatFinder waitingSeatFinder = new WaitingSeatFinder("input/DayElevenTest3.txt");

        int seatCount = waitingSeatFinder.countSeats();

        assertEquals(37, seatCount);
    }

    @Test
    void runNewRulesRoundOne() {
        WaitingSeatFinder waitingSeatFinderZero = new WaitingSeatFinder("input/DayElevenTest0.txt");

        boolean stabilised = waitingSeatFinderZero.runRules(true);

        assertFalse(stabilised);

        WaitingSeatFinder waitingSeatFinderOne = new WaitingSeatFinder("input/DayElevenTest1.txt");

        assertEquals(waitingSeatFinderOne.getFloorPlan(), waitingSeatFinderZero.getFloorPlan());
    }

    @Test
    void runNewRulesRoundTwo() {
        WaitingSeatFinder waitingSeatFinderZero = new WaitingSeatFinder("input/DayElevenTest1.txt");

        boolean stabilised = waitingSeatFinderZero.runRules(true);

        assertFalse(stabilised);

        WaitingSeatFinder waitingSeatFinderOne = new WaitingSeatFinder("input/DayElevenTest4.txt");

        assertEquals(waitingSeatFinderOne.getFloorPlan(), waitingSeatFinderZero.getFloorPlan());
    }

    @Test
    void runNewRules() {
        WaitingSeatFinder waitingSeatFinderZero = new WaitingSeatFinder("input/DayElevenTest4.txt");

        boolean stabilised = waitingSeatFinderZero.runRules(true);

        assertFalse(stabilised);

        WaitingSeatFinder waitingSeatFinderOne = new WaitingSeatFinder("input/DayElevenTest5.txt");

        assertEquals(waitingSeatFinderOne.getFloorPlan(), waitingSeatFinderZero.getFloorPlan());
    }
}