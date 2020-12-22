package com.yokall.dayeleven;

import java.awt.*;
import java.util.List;

public class SeatDecider {
    public static char decideSeat(List<List<Character>> floorPlan, int x, int y, boolean newRules) {
        char currentChar = floorPlan.get(y).get(x);

        if (newRules) {
            return newRules(floorPlan, x, y, currentChar);
        }

        return oldRules(floorPlan, x, y, currentChar);
    }

    private static char oldRules(List<List<Character>> floorPlan, int x, int y, char currentChar) {
        if ('L' == currentChar) {
            if (
                    isOutOfBoundsOrUnoccupied(floorPlan, x - 1, y - 1) &&
                            isOutOfBoundsOrUnoccupied(floorPlan, x, y - 1) &&
                            isOutOfBoundsOrUnoccupied(floorPlan, x + 1, y - 1) &&
                            isOutOfBoundsOrUnoccupied(floorPlan, x - 1, y) &&
                            isOutOfBoundsOrUnoccupied(floorPlan, x + 1, y) &&
                            isOutOfBoundsOrUnoccupied(floorPlan, x - 1, y + 1) &&
                            isOutOfBoundsOrUnoccupied(floorPlan, x, y + 1) &&
                            isOutOfBoundsOrUnoccupied(floorPlan, x + 1, y + 1)
            ) {
                return '#';
            }
        } else if ('#' == currentChar) {
            if (4 <= (
                    isOccupied(floorPlan, x - 1, y - 1) +
                            isOccupied(floorPlan, x, y - 1) +
                            isOccupied(floorPlan, x + 1, y - 1) +
                            isOccupied(floorPlan, x - 1, y) +
                            isOccupied(floorPlan, x + 1, y) +
                            isOccupied(floorPlan, x - 1, y + 1) +
                            isOccupied(floorPlan, x, y + 1) +
                            isOccupied(floorPlan, x + 1, y + 1)
            )) {
                return 'L';
            }
        }

        return floorPlan.get(y).get(x);
    }

    private static char newRules(List<List<Character>> floorPlan, int x, int y, char currentChar) {
        Point north = findSeatInDirection(floorPlan, x, y, Direction.N);
        Point northEast = findSeatInDirection(floorPlan, x, y, Direction.NE);
        Point east = findSeatInDirection(floorPlan, x, y, Direction.E);
        Point southEast = findSeatInDirection(floorPlan, x, y, Direction.SE);
        Point south = findSeatInDirection(floorPlan, x, y, Direction.S);
        Point southWest = findSeatInDirection(floorPlan, x, y, Direction.SW);
        Point west = findSeatInDirection(floorPlan, x, y, Direction.W);
        Point northWest = findSeatInDirection(floorPlan, x, y, Direction.NW);

        if ('L' == currentChar) {
            if (
                    isOutOfBoundsOrUnoccupied(floorPlan, north.x, north.y) &&
                            isOutOfBoundsOrUnoccupied(floorPlan, northEast.x, northEast.y) &&
                            isOutOfBoundsOrUnoccupied(floorPlan, east.x, east.y) &&
                            isOutOfBoundsOrUnoccupied(floorPlan, southEast.x, southEast.y) &&
                            isOutOfBoundsOrUnoccupied(floorPlan, south.x, south.y) &&
                            isOutOfBoundsOrUnoccupied(floorPlan, southWest.x, southWest.y) &&
                            isOutOfBoundsOrUnoccupied(floorPlan, west.x, west.y) &&
                            isOutOfBoundsOrUnoccupied(floorPlan, northWest.x, northWest.y)
            ) {
                return '#';
            }
        } else if ('#' == currentChar) {
            if (5 <= (
                    isOccupied(floorPlan, north.x, north.y) +
                            isOccupied(floorPlan, northEast.x, northEast.y) +
                            isOccupied(floorPlan, east.x, east.y) +
                            isOccupied(floorPlan, southEast.x, southEast.y) +
                            isOccupied(floorPlan, south.x, south.y) +
                            isOccupied(floorPlan, southWest.x, southWest.y) +
                            isOccupied(floorPlan, west.x, west.y) +
                            isOccupied(floorPlan, northWest.x, northWest.y)
            )) {
                return 'L';
            }
        }

        return floorPlan.get(y).get(x);
    }

    private static boolean isOutOfBoundsOrUnoccupied(List<List<Character>> floorPlan, int x, int y) {
        return x < 0 || x == floorPlan.get(0).size() || y < 0 || y == floorPlan.size() ||
                floorPlan.get(y).get(x) == 'L' || floorPlan.get(y).get(x) == '.';
    }

    private static int isOccupied(List<List<Character>> floorPlan, int x, int y) {
        if (x >= 0 && x < floorPlan.get(0).size() && y >= 0 && y < floorPlan.size() && floorPlan.get(y).get(x) == '#') {
            return 1;
        }

        return 0;
    }

    private static Point findSeatInDirection(List<List<Character>> floorPlan, int x, int y, Direction direction) {
        Point newPoint;

        switch (direction) {
            case N:
                newPoint = new Point(x, y - 1);
                break;
            case NE:
                newPoint = new Point(x + 1, y - 1);
                break;
            case E:
                newPoint = new Point(x + 1, y);
                break;
            case SE:
                newPoint = new Point(x + 1, y + 1);
                break;
            case S:
                newPoint = new Point(x, y + 1);
                break;
            case SW:
                newPoint = new Point(x - 1, y + 1);
                break;
            case W:
                newPoint = new Point(x - 1, y);
                break;
            default:
                newPoint = new Point(x - 1, y - 1);
        }

        if (isOutOfBounds(floorPlan, newPoint.x, newPoint.y))
            return new Point(newPoint.x, newPoint.y);

        if (floorPlan.get(newPoint.y).get(newPoint.x) == '.')
            return findSeatInDirection(floorPlan, newPoint.x, newPoint.y, direction);

        return new Point(newPoint.x, newPoint.y);
    }

    private static boolean isOutOfBounds(List<List<Character>> floorPlan, int x, int y) {
        return x < 0 || x == floorPlan.get(0).size() || y < 0 || y == floorPlan.size();
    }
}
