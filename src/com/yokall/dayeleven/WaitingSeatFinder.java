package com.yokall.dayeleven;

import com.yokall.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class WaitingSeatFinder {

    private List<List<Character>> floorPlan;

    private boolean stabilised;

    public boolean isNotStabilised() {
        return !stabilised;
    }

    public List<List<Character>> getFloorPlan() {
        return floorPlan;
    }

    public WaitingSeatFinder(String input) {
        stabilised = false;

        floorPlan = new ArrayList<>();

        List<String> lines = FileUtils.readLinesToArray(input);

        for (String line : lines) {
            List<Character> characters = new ArrayList<>();

            for (int i = 0; i < line.length(); i++) {
                characters.add(line.charAt(i));
            }

            floorPlan.add(characters);
        }
    }

    public boolean runRules(boolean newRules) {
        List<List<Character>> newFloorPlan = new ArrayList<>();

        for (int y = 0; y < floorPlan.size(); y++) {
            List<Character> line = new ArrayList<>();
            for (int x = 0; x < floorPlan.get(y).size(); x++) {
                line.add(SeatDecider.decideSeat(floorPlan, x, y, newRules));
            }

            newFloorPlan.add(line);
        }

        stabilised = floorPlan.equals(newFloorPlan);

        floorPlan = newFloorPlan;

        return stabilised;
    }

    public int countSeats() {
        int count = 0;

        for (List<Character> characters : floorPlan) {
            for (Character character : characters) {
                if (character == '#') {
                    count++;
                }
            }
        }

        return count;
    }
}
