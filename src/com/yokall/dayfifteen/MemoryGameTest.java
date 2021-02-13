package com.yokall.dayfifteen;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryGameTest {

    private MemoryGame memoryGame;

    @BeforeEach
    void setUp() {
        memoryGame = new MemoryGame();
    }

    @Nested
    class PartOne {

        @Test
        void exampleOne() {
            List<Integer> startingNumbers = new ArrayList<>(Arrays.asList(0, 3, 6));
            int numberOfTurns = 10;

            int actual = memoryGame.partOne(startingNumbers, numberOfTurns);

            assertEquals(0, actual);
        }

        @Test
        void exampleTwo() {
            List<Integer> startingNumbers = new ArrayList<>(Arrays.asList(1, 3, 2));
            int numberOfTurns = 2020;

            int actual = memoryGame.partOne(startingNumbers, numberOfTurns);

            assertEquals(1, actual);
        }

        @Test
        void exampleThree() {
            List<Integer> startingNumbers = new ArrayList<>(Arrays.asList(2, 1, 3));
            int numberOfTurns = 2020;

            int actual = memoryGame.partOne(startingNumbers, numberOfTurns);

            assertEquals(10, actual);
        }

        @Test
        void exampleFour() {
            List<Integer> startingNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
            int numberOfTurns = 2020;

            int actual = memoryGame.partOne(startingNumbers, numberOfTurns);

            assertEquals(27, actual);
        }

        @Test
        void exampleFive() {
            List<Integer> startingNumbers = new ArrayList<>(Arrays.asList(2, 3, 1));
            int numberOfTurns = 2020;

            int actual = memoryGame.partOne(startingNumbers, numberOfTurns);

            assertEquals(78, actual);
        }

        @Test
        void exampleSix() {
            List<Integer> startingNumbers = new ArrayList<>(Arrays.asList(3, 2, 1));
            int numberOfTurns = 2020;

            int actual = memoryGame.partOne(startingNumbers, numberOfTurns);

            assertEquals(438, actual);
        }

        @Test
        void exampleSeven() {
            List<Integer> startingNumbers = new ArrayList<>(Arrays.asList(3, 1, 2));
            int numberOfTurns = 2020;

            int actual = memoryGame.partOne(startingNumbers, numberOfTurns);

            assertEquals(1836, actual);
        }
    }
}