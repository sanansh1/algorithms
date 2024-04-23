package org.amazon;

import java.util.Arrays;

/*
Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n.
Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if the length
of the rod is 8 and the values of different pieces are given as the following, then the maximum obtainable value
is 22 (by cutting in two pieces of lengths 2 and 6)
length   | 1   2   3   4   5   6   7   8
--------------------------------------------
price    | 3   5   8   9  10  17  17  20

Method 1: A naive solution to this problem is to generate all configurations of different pieces and
find the highest-priced configuration. This solution is exponential in terms of time complexity.
Let us see how this problem possesses both important properties of a Dynamic Programming (DP)
Problem and can efficiently be solved using Dynamic Programming.
 */
public class RodCutting {
    public static int cutRod(int[] prices, int n) {
        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return findBestPrice(prices, prices.length - 1, n, dp);
    }

    public static int findBestPrice(int[] prices, int index, int n, int[][] dp) {
        if (index == 0) {
            return n * prices[0];
        }
        if (dp[index][n] != -1) {
            return dp[index][n];
        }
        if (n == 0) {
            return 0;
        }
        // At any index we have 2 options either
        // cut the rod of this length or not cut
        // it
        int notCut = findBestPrice(prices, index - 1, n, dp);
        int cut = Integer.MIN_VALUE;
        int rodLength = index + 1;
        int newLength = n - rodLength;
        if (rodLength <= n) {
            cut = prices[index] + findBestPrice(prices, newLength - 1, n, dp);
        }
        return dp[index][n] = Math.max(notCut, cut);
    }

    public static void main(String[] s) {
        int[] arr = {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is "
                + cutRod(arr, size));
    }
}
