package org.dynamicprogramming;

import java.util.Arrays;

public class FrogJumpWithKDistance {
    public static int countFrogJumpWithK(int[] height, int K, int N) {
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);
        return countJumpsWithK(height, K, N, dp);
    }

    public static int countJumpsWithK(int[] height, int K, int N, int[] dp) {
        if (N == 0) {
            return dp[0] = height[0];
        }
        if (N == 1) {
            return dp[1] = height[0] + Math.abs(height[1] - height[0]);
        }
        if (dp[N] != -1) {
            return dp[N];
        }
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= K; j++) {
            if (N - j >= 0) {
                int curr = countJumpsWithK(height, K, N - j, dp) + Math.abs(height[j] - height[N - j]);
                min = Math.min(min, curr);
            }
        }
        return dp[N] = min;
    }

    public static void main(String[] s) {
        System.out.println(countFrogJumpWithK(new int[]{30, 10, 60, 10, 60, 50}, 3, 5));
    }
}
