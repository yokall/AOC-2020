package com.yokall.dayfive;

public class SeatFinder {
    int lowestRow;
    int highestRow;

    int lowestSeat;
    int highestSeat;

    public SeatFinder() {
        lowestRow = 0;
        highestRow = 127;

        lowestSeat = 0;
        highestSeat = 7;
    }

    public int findSeatId(String seatReference) {
        for (int i = 0; i < 10; i++) {
            char character = seatReference.charAt(i);

            reduceRange(character);
        }

        return (highestRow * 8) + highestSeat;
    }

    private void reduceRange(char character) {


        if (character == 'F' || character == 'B') {
            int middle = (highestRow - lowestRow) / 2;

            if (character == 'F') {
                highestRow = lowestRow + middle;
            } else {
                lowestRow = highestRow - middle;
            }
        }

        if (character == 'L' || character == 'R') {
            int middle = (highestSeat - lowestSeat) / 2;

            if (character == 'L') {
                highestSeat = lowestSeat + middle;
            } else {
                lowestSeat = highestSeat - middle;
            }
        }
    }
}
