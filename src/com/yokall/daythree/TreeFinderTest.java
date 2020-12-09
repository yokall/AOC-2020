package com.yokall.daythree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeFinderTest {

    TreeFinder treeFinder;

    String[] map;

    @BeforeEach
    void setUp() {
        treeFinder = new TreeFinder();

        map = new String[]{
                "..##.......",
                "#...#...#..",
                ".#....#..#.",
                "..#.#...#.#",
                ".#...##..#.",
                "..#.##.....",
                ".#.#.#....#",
                ".#........#",
                "#.##...#...",
                "#...##....#",
                ".#..#...#.#"
        };
    }

    @Test
    void findTreesPartOne() {
        int[] slope = {3, 1};

        int actual = treeFinder.findTreesPartOne(map, slope, 0, 0, 0);

        Assertions.assertEquals(7, actual);
    }

    @Test
    void findTreesPartTwo() {
        int[][] slopes = {
                {1, 1},
                {3, 1},
                {5, 1},
                {7, 1},
                {1, 2}
        };

        long actual = treeFinder.findTreesPartTwo(map, slopes);

        Assertions.assertEquals(336L, actual);
    }
}