package com.gs.incubation.task8;

public class OptimalPath {

    public static Integer optimalPath(Integer[][] grid) {
        if (grid == null || grid.length == 0) {
            throw new IllegalArgumentException("Invalid i/p");
        }
        int temp1 = 0, temp2 = 0;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = 0; j < grid[i].length; j++) {
                temp1 = (j - 1) >= 0 ? grid[i][j - 1] : 0;
                temp2 = (i + 1) <= grid.length - 1 ? grid[i + 1][j] : 0;
                grid[i][j] += Math.max(temp1, temp2);
            }
        }
        return grid[0][grid[0].length - 1];
    }

    public static void main(String[] args) {
        Integer[][] i1 = {{0, 0, 0, 0, 5},
                {0, 1, 1, 1, 0},
                {2, 0, 0, 0, 0}};
        System.out.println(OptimalPath.optimalPath(i1));

        Integer[][] i2 = {{0, 0, 0, 0, 5},
                {0, 5, 1, 1, 0},
                {2, 4, 9, 8, 0}};
        System.out.println(OptimalPath.optimalPath(i2));

        Integer[][] i3 = {{10, 10, 10, 0, 5},
                {0, 1, 1, 1, 0},
                {2, 0, 0, 0, 0}};
        System.out.println(OptimalPath.optimalPath(i3));

        Integer[][] i4 = {{0, 0, 0, 0, 5}};
        System.out.println(OptimalPath.optimalPath(i4));

    }
}
