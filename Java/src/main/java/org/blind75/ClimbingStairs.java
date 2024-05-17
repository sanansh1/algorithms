package org.blind75;

import java.util.Arrays;

public class ClimbingStairs {
    public static int findWays(int N) {
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);
        return helper(N, dp);

    }

    static int helper(int index, int[] dp) {
        if (index == 0 || index == 1) {
            return 1;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int left = helper(index - 1, dp);
        int right = helper(index - 2, dp);
        return dp[index] = left + right;
    }

    public static void main(String[] s) {
        System.out.print(findWays(3));
    }
}
