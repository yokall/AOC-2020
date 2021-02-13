package com.yokall.dayfifteen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryGame {

    public int partOne(List<Integer> startingNumbers, int numberOfTurns) {
        int currentTurn = 1;
        Map<Integer, Integer> numberRecord = new HashMap<>();
        int lastSaidNumber = startingNumbers.get(0);

        for (int j = 1; j < startingNumbers.size(); j++) {
            numberRecord.put(lastSaidNumber, currentTurn);

            ++currentTurn;

            lastSaidNumber = startingNumbers.get(j);
        }

         for (int i = currentTurn; i < numberOfTurns; i++) {
            ++currentTurn;

            int currentNumber;
            if (numberRecord.containsKey(lastSaidNumber)) {
                currentNumber = (currentTurn - 1) - numberRecord.get(lastSaidNumber);
            } else {

                currentNumber = 0;
            }

            numberRecord.put(lastSaidNumber, currentTurn - 1);

            lastSaidNumber = currentNumber;
        }

        return lastSaidNumber;
    }
}
