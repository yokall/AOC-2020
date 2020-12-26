package com.yokall.daytwelve;

import com.yokall.dayeleven.Direction;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NavigationComputer {
    private List<String> instructions;
    private int x;
    private int y;
    private Direction facing;

    private Point waypointPosition;

    private static final List<String> DIRECTIONARRAY = new ArrayList<>(Arrays.asList("N", "E", "S", "W"));

    public NavigationComputer(List<String> instructions) {
        x = 0;
        y = 0;

        facing = Direction.E;

        waypointPosition = new Point(10,1);

        this.instructions = instructions;
    }

    public int runInstructions() {
        for (String instruction : instructions) {
            String command = instruction.substring(0, 1);
            int value = Integer.parseInt(instruction.substring(1));

            switch (command) {
                case "F":
                    switch (facing) {
                        case N:
                            y += value;
                            break;
                        case E:
                            x += value;
                            break;
                        case S:
                            y -= value;
                            break;
                        case W:
                            x -= value;
                    }
                    break;
                case "N":
                    y += value;
                    break;
                case "E":
                    x += value;
                    break;
                case "S":
                    y -= value;
                    break;
                case "W":
                    x -= value;
                    break;
                case "R":
                case "L":
                    int startingIndex = DIRECTIONARRAY.indexOf(facing.toString());
                    int moveIndex = value / 90;

                    int newDirectionIndex;
                    if (command.equals("L")) {
                        newDirectionIndex = ((startingIndex + 4) - moveIndex) % 4;
                    } else {
                        newDirectionIndex = (startingIndex + moveIndex) % 4;
                    }

                    facing = Direction.valueOf(DIRECTIONARRAY.get(newDirectionIndex));
                    break;
            }
        }

        return Math.abs(x) + Math.abs(y);
    }

    public int runInstructionsTwo() {
        for (String instruction : instructions) {
            String command = instruction.substring(0, 1);
            int value = Integer.parseInt(instruction.substring(1));

            switch (command) {
                case "F":
                    int moveX = waypointPosition.x * value;
                    int moveY = waypointPosition.y * value;

                    x += moveX;
                    y += moveY;
                    break;
                case "N":
                    waypointPosition.y += value;
                    break;
                case "E":
                    waypointPosition.x += value;
                    break;
                case "S":
                    waypointPosition.y -= value;
                    break;
                case "W":
                    waypointPosition.x -= value;
                    break;
                case "R":
                case "L":
                    if (command.equals("L")) {
                        value = 360 - value;
                    }

                    int newX = waypointPosition.x;
                    int newY = waypointPosition.y;

                    if (value == 90) {
                        newX = waypointPosition.y;
                        newY = waypointPosition.x * -1;

                    } else if (value == 180) {
                        newX = waypointPosition.x * -1;
                        newY = waypointPosition.y * -1;
                    } else if (value == 270) {
                        newX = waypointPosition.y * -1;
                        newY = waypointPosition.x;
                    }

                    waypointPosition.x = newX;
                    waypointPosition.y = newY;
                    break;
            }
        }

        return Math.abs(x) + Math.abs(y);
    }
}
