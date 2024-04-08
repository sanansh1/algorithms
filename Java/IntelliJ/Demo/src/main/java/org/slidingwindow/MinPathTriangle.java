package org.slidingwindow;

import java.util.Arrays;

public class MinPathTriangle {
    public static int minPathTriangle(int[][] triangle) {
        // recursion
        // do all stuff at index
        // explore all possibilities
        //find min
        // brute force
        int[][] dp = new int[triangle.length][triangle[0].length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minPath(0, 0, triangle);
        //minPathDP(0, 0, triangle,dp);
    }

    public static int minPath(int i, int j, int[][] triangle) {
        if (i == triangle.length - 1) {
            return triangle[i][j];
        }
        int down = triangle[i][j] + minPath(i + 1, j, triangle);
        int diagonal = triangle[i][j] + minPath(i + 1, j + 1, triangle);
        return Math.min(down, diagonal);
    }

    public static int minPathDP(int i, int j, int[][] triangle, int[][] dp) {
        if (i == triangle.length - 1) {
            return triangle[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = triangle[i][j] + minPathDP(i + 1, j, triangle, dp);
        int diagonal = triangle[i][j] + minPathDP(i + 1, j + 1, triangle, dp);
        return dp[i][j] = Math.min(down, diagonal);
    }

    public static int minPathTabulation(int i, int j, int[][] triangle, int[][] dp) {
        // TODO
        if (i == triangle.length - 1) {
            return triangle[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = triangle[i][j] + minPathDP(i + 1, j, triangle, dp);
        int diagonal = triangle[i][j] + minPathDP(i + 1, j + 1, triangle, dp);
        return dp[i][j] = Math.min(down, diagonal);
    }

    public static void main(String[] s) {

    }
}
