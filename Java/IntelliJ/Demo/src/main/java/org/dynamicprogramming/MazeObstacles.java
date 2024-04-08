package org.dynamicprogramming;

import java.util.Arrays;

public class MazeObstacles {
    public static void main(String[] s) {
        int[][] maze = {
                {0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}
        };

        int n = maze.length;
        int m = maze[0].length;

        // Calculate and print the number of paths through the maze
        System.out.println(countWays(maze));
        int[][] dp = new int[maze.length][maze[0].length];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(countWaysUtilTabulation(maze, dp));
    }

    public static int countWays(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return countWaysUtilDP(arr.length - 1, arr[0].length - 1, arr, dp);
    }

    public static int countWaysUtilDP(int i, int j, int[][] arr, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }

        if (i > 0 && j > 0 && arr[i][j] == -1) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int left = countWaysUtilDP(i - 1, j, arr, dp);
        int up = countWaysUtilDP(i, j - 1, arr, dp);
        return dp[i][j] = left + up;
    }

    public static int countWaysUtilTabulation(int[][] arr, int[][] dp) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                } else if (arr[i][j] == -1) {
                    dp[i][j] = 0;
                } else {
                    int right = 0, down = 0;
                    if (i > 0) right = dp[i - 1][j];
                    if (j > 0) down = dp[i][j - 1];
                    dp[i][j] = right + down;
                }
            }
        }
        return dp[arr.length - 1][arr[0].length - 1];
    }
}
