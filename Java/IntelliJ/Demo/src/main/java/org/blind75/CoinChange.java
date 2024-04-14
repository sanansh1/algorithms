package org.blind75;

import java.util.Arrays;

/**
 * You are given an infinite supply of coins of each of denominations D = {D0, D1, D2, D3, ...... Dn-1}.
 * You need to figure out the total number of ways W, in which you can make a change for value V using coins of
 * denominations from D. Print 0, if a change isn't possible.
 */
public class CoinChange {
    // We need to generate all the subsequences. We will use the pick/non-pick technique
    public static int coinChange(int[] denomination, int target) {
        int[] dp = new int[denomination.length];
        Arrays.fill(dp, -1);
        return countWays(denomination.length - 1, target, denomination, dp);
    }

    public static int countWays(int index, int target, int[] denomination, int[] dp) {
        if (index == 0) {
            return target % denomination[index] == 0 ? 1 : 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int notTake = countWays(index - 1, target, denomination, dp);
        int take = 0;
        if (denomination[index] <= target) {
            take = countWays(index, target - denomination[index], denomination, dp);
        }
        return dp[index] = notTake + take;
    }

    public static void main(String[] s) {
        int[] arr = new int[]{1, 2, 3};
        int target = 4;
        System.out.println("The total number of ways is : " + coinChange(arr, target));
    }
}
