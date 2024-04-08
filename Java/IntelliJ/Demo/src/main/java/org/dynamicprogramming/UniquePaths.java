package org.dynamicprogramming;

import java.util.Arrays;

public class UniquePaths {

    public static int countWays(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp, -1);
        return countWaysUtil(m - 1, n - 1, dp);
    }

    public static int countWaysUtil(int i, int j, int[][] dp) {
        if (i == 0 && j == 0) {
            return dp[0][0] = 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int up = countWaysUtil(i - 1, j, dp);
        int left = countWaysUtil(i, j - 1, dp);
        return dp[i][j] = up + left;
    }
}
