package com.yokall.dayeight;

import java.util.ArrayList;
import java.util.List;

public class BootCodeRunner {
    private int accumulator;

    public int getAccumulator() {
        return accumulator;
    }

    private List<String> instructions;

    public BootCodeRunner(List<String> instructions) {
        this.instructions = instructions;

        accumulator = 0;
    }

    public boolean safeRunInstructions() {
        int instructionNumber = 0;

        List<Integer> instructionsRan = new ArrayList<>();

        while (!instructionsRan.contains(instructionNumber) && instructionNumber < instructions.size()) {
            instructionsRan.add(instructionNumber);

            String instruction = instructions.get(instructionNumber);

            String[] splitInstruction = instruction.split(" ");

            if (splitInstruction[0].equals("acc")) {
                accumulator += Integer.parseInt(splitInstruction[1]);
                instructionNumber++;
            } else if (splitInstruction[0].equals("jmp")) {
                instructionNumber += Integer.parseInt(splitInstruction[1]);
            } else {
                instructionNumber++;
            }
        }

        return instructionsRan.contains(instructions.size() - 1);
    }


}
