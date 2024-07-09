package org.dynamicprogramming;

import java.util.Arrays;

/**
 * We are given an array Arr with N distinct coins and a target.
 * We have an infinite supply of each coin denomination. We need to find the number of
 * ways we sum up the coin values to give us the target.
 * Step 1: Express the problem in terms of indexes.
 * <p>
 * We are given ‘n’ coins. Their denomination value is given by the array ‘arr’.
 * So clearly one parameter will be ‘ind’, i.e index up to which the array items are
 * being considered.
 * Base Cases:
 * <p>
 * If ind==0, it means we are at the first item so we have only one
 * coin denomination, therefore the following two cases can arise:
 * Try out all possible choices at a given index. - We need to generate all
 * the subsequences. We will use the pick/non-pick technique
 */
public class CoinChange {

    public static int countWaysToMakeChange(int[] arr, int n, int T) {
        int[][] dp = new int[n][T + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return countWaysToMakeChangeUtil(arr, n - 1, T, dp);
    }

    public static int countWaysToMakeChangeUtil(int[] arr, int n, int T, int[][] dp) {
        if (n == 0) {
            if (T % arr[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[n][T] != -1)
            return dp[n][T];

        int notTaken = countWaysToMakeChangeUtil(arr, n - 1, T, dp);
        int taken = 0;
        if (arr[n] <= T) {
            taken = countWaysToMakeChangeUtil(arr, n, T - arr[n], dp);
        }
        return dp[n][T] = notTaken + taken;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int target = 4;
        int n = arr.length;

        // Call the countWaysToMakeChange function and print the result
        System.out.println("The total number of ways is " + countWaysToMakeChange(arr, n, target));
    }


}
