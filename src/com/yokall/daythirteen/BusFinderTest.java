package com.yokall.daythirteen;

import com.yokall.FileUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BusFinderTest {

    @Test
    void findEarliestBus() {
        List<String> input = FileUtils.readLinesToArray("input/DayThirteenTest.txt");

        int earliestDepartTime = Integer.parseInt(input.get(0));
        String buses = input.get(1);

        int actual = BusFinder.findEarliestBus(earliestDepartTime, buses);

        assertEquals(295, actual);
    }

    @Test
    void findSyncTimestamp() {
        long actual = BusFinder.findSyncTimestamp("7,13,x,x,59,x,31,19");

        assertEquals(1068781L, actual);
    }

    @Test
    void findSyncTimestamp1() {
        long actual = BusFinder.findSyncTimestamp("17,x,13,19");

        assertEquals(3417L, actual);
    }

    @Test
    void findSyncTimestamp2() {
        long actual = BusFinder.findSyncTimestamp("67,7,59,61");

        assertEquals(754018L, actual);
    }

    @Test
    void findSyncTimestamp3() {
        long actual = BusFinder.findSyncTimestamp("67,x,7,59,61");

        assertEquals(779210L, actual);
    }

    @Test
    void findSyncTimestamp4() {
        long actual = BusFinder.findSyncTimestamp("67,7,x,59,61");

        assertEquals(1261476L, actual);
    }

    @Test
    void findSyncTimestamp5() {
        long actual = BusFinder.findSyncTimestamp("1789,37,47,1889");

        assertEquals(1202161486L, actual);
    }
}