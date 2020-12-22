package com.yokall.dayeleven;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeatDeciderTest {

    @Test
    void decideSeatOccupied() {
        WaitingSeatFinder waitingSeatFinder = new WaitingSeatFinder("input/DayElevenTest0.txt");

        char actual = SeatDecider.decideSeat(waitingSeatFinder.getFloorPlan(), 0, 0, false);

        assertEquals('#', actual);
    }

    @Test
    void decideSeatUnOccupied() {
        WaitingSeatFinder waitingSeatFinder = new WaitingSeatFinder("input/DayElevenTest1.txt");

        char actual = SeatDecider.decideSeat(waitingSeatFinder.getFloorPlan(), 2, 0, false);

        assertEquals('L', actual);
    }

    @Test
    void decideSeatOccupiedNoChange() {
        WaitingSeatFinder waitingSeatFinder = new WaitingSeatFinder("input/DayElevenTest1.txt");

        char actual = SeatDecider.decideSeat(waitingSeatFinder.getFloorPlan(), 0, 0, false);

        assertEquals('#', actual);
    }

    @Test
    void decideSeatUnOccupiedNoChange() {
        WaitingSeatFinder waitingSeatFinder = new WaitingSeatFinder("input/DayElevenTest2.txt");

        char actual = SeatDecider.decideSeat(waitingSeatFinder.getFloorPlan(), 5, 0, false);

        assertEquals('L', actual);
    }

    @Test
    void decideSeatFloorNoChange() {
        WaitingSeatFinder waitingSeatFinder = new WaitingSeatFinder("input/DayElevenTest0.txt");

        char actual = SeatDecider.decideSeat(waitingSeatFinder.getFloorPlan(), 1, 0, false);

        assertEquals('.', actual);
    }

    @Test
    void decideSeatOccupiedNewRules() {
        WaitingSeatFinder waitingSeatFinder = new WaitingSeatFinder("input/DayElevenTest0.txt");

        char actual = SeatDecider.decideSeat(waitingSeatFinder.getFloorPlan(), 0, 0, true);

        assertEquals('#', actual);
    }

    @Test
    void decideSeatUnOccupiedNewRules() {
        WaitingSeatFinder waitingSeatFinder = new WaitingSeatFinder("input/DayElevenTest1.txt");

        char actual = SeatDecider.decideSeat(waitingSeatFinder.getFloorPlan(), 2, 0, true);

        assertEquals('L', actual);
    }

    @Test
    void decideSeatOccupiedNoChangeNewRules() {
        WaitingSeatFinder waitingSeatFinder = new WaitingSeatFinder("input/DayElevenTest1.txt");

        char actual = SeatDecider.decideSeat(waitingSeatFinder.getFloorPlan(), 0, 0, true);

        assertEquals('#', actual);
    }

    @Test
    void decideSeatUnOccupiedNoChangeNewRules() {
        WaitingSeatFinder waitingSeatFinder = new WaitingSeatFinder("input/DayElevenTest4.txt");

        char actual = SeatDecider.decideSeat(waitingSeatFinder.getFloorPlan(), 2, 0, true);

        assertEquals('L', actual);
    }

    @Test
    void decideSeatFloorNoChangeNewRules() {
        WaitingSeatFinder waitingSeatFinder = new WaitingSeatFinder("input/DayElevenTest0.txt");

        char actual = SeatDecider.decideSeat(waitingSeatFinder.getFloorPlan(), 1, 0, true);

        assertEquals('.', actual);
    }
}