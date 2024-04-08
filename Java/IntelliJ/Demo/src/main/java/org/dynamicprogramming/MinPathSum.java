package org.dynamicprogramming;

import java.util.Arrays;

public class MinPathSum {
    public static void main(String[] s) {
// Define the matrix
        int[][] matrix = {
                {5, 9, 6},
                {11, 5, 2}
        };

        int n = matrix.length;
        int m = matrix[0].length;

        // Calculate and print the minimum sum path in the matrix
        System.out.println(minSum(matrix));
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(minSumUtilTabulation(matrix, dp));
    }

    public static int minSum(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minSumUtil(arr, arr.length - 1, arr[0].length - 1, dp);
    }

    public static int minSumUtil(int[][] arr, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) return (int) Math.pow(10, 9);
        if (i == 0 && j == 0) return arr[0][0];
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int left = arr[i][j] + minSumUtil(arr, i - 1, j, dp);
        int right = arr[i][j] + minSumUtil(arr, i, j - 1, dp);
        return dp[i][j] = Math.min(left, right);
    }

    public static int minSumUtilTabulation(int[][] arr, int[][] dp) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == 0 && j == 0) dp[0][0] = arr[0][0];
                else {
                    int left = arr[i][j], right = arr[i][j];
                    if (i > 0) left += dp[i - 1][j];
                    else left += (int) Math.pow(10, 9);
                    if (j > 0) right += dp[i][j - 1];
                    else right += (int) Math.pow(10, 9);
                    dp[i][j] = Math.min(left, right);
                }
            }
        }

        return dp[arr.length - 1][arr[0].length - 1];
    }
}
