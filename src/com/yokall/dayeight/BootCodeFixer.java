package com.yokall.dayeight;

import java.util.ArrayList;
import java.util.List;

public class BootCodeFixer {
    public int fixBootInstructions(List<String> instructions) {
        List<Integer> possiblyCorruptedInstructionNumbers = new ArrayList<>();

        for (int i = 0; i < instructions.size(); i++) {
            if (instructions.get(i).startsWith("jmp") || instructions.get(i).startsWith("nop")) {
                possiblyCorruptedInstructionNumbers.add(i);
            }
        }

        for (int instructionNumber: possiblyCorruptedInstructionNumbers){
            List<String> fixedInstructions = generateFixedInstructions(instructions, instructionNumber);

            BootCodeRunner bootCodeRunner = new BootCodeRunner(fixedInstructions);

            if (bootCodeRunner.safeRunInstructions()) {
                return bootCodeRunner.getAccumulator();
            }
        }

        return -1;
    }

    private List<String> generateFixedInstructions(List<String> instructions, int instructionNumber) {
        List<String> newInstructions = new ArrayList<>(instructions);

        String fixedInstruction = newInstructions.get(instructionNumber);

        if (fixedInstruction.startsWith("jmp")) {
            fixedInstruction = fixedInstruction.replace("jmp", "nop");
        }
        else {
            fixedInstruction = fixedInstruction.replace("nop", "jmp");
        }

        newInstructions.set(instructionNumber, fixedInstruction);

        return newInstructions;
    }
}
