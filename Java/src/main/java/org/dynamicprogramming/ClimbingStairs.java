package org.dynamicprogramming;

import java.util.Arrays;

/**
 * Given a number of stairs. Starting from the 0th stair we need to
 * climb to the “Nth” stair. At a time we can climb either one or two steps.
 * We need to return the total number of distinct ways to reach from 0th to Nth stair.
 */
public class ClimbingStairs {

    public static int climbingStairs(int N) {
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);
        return countClimbingStairs(N, dp);
    }

    public static int countClimbingStairs(int ind, int[] dp) {
        //System.out.print(ind + ":");
        if (ind <= 1) {
            return 1;
        }
        if (dp[ind] != -1) {
            return dp[ind];
        }
        return dp[ind] = countClimbingStairs(ind - 1, dp) + countClimbingStairs(ind - 2, dp);
    }

    public static void main(String[] s) {
        int res = climbingStairs(5);
        System.out.println(res);
    }
}
