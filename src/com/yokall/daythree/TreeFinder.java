package com.yokall.daythree;

public class TreeFinder {

    public static final char TREE = '#';

    public int findTreesPartOne(String[] map, int[] slope, int x, int y, int treeCount) {
        int localX = x % map[0].length();

        char newLocation = map[y].charAt(localX);

        if (newLocation == TREE) {
            treeCount++;
        }

        if (y == map.length - 1) {
            return  treeCount;
        }

        x += slope[0];
        y += slope[1];

        if (y >= map.length) {
            y = map.length - 1;
        }

        return findTreesPartOne(map, slope, x, y, treeCount);
    }

    public long findTreesPartTwo(String[] map, int[][] slopes) {
        long answer = 1L;

        for (int[] slope : slopes) {
            answer *= findTreesPartOne(map, slope, 0, 0, 0);
        }

        return answer;
    }
}
