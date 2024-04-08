package org.dynamicprogramming;

import java.util.Arrays;

public class FrogJump {

    public static int calcMinJump(int[] heights, int N, int[] dp) {
        if (N == 0) {
            return heights[0];
        }
        if (dp[N] != -1) {
            return dp[N];
        }
        int right = Integer.MAX_VALUE;
        int left = calcMinJump(heights, N - 1, dp) + Math.abs(heights[N - 1] - heights[N]);
        if (N - 1 > 1) {
            right = calcMinJump(heights, N - 2, dp) + Math.abs(heights[N - 2] - heights[N]);
        }
        return Math.min(left, right);
    }

    public static int calcMinJumpTabular(int[] heights, int N, int[] dp) {
        dp[0] = heights[0];
        dp[1] = dp[0] + Math.abs(heights[1] - heights[0]);
        for (int i = 2; i < N; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]);
        }
        return dp[N];
    }

    public static int calcMinJumpTabularSpaceOptimized(int[] heights, int N) {
        int prev2 = heights[0];
        int prev1 = heights[0] + Math.abs(heights[1] - heights[0]);
        int curr = 0;
        for (int i = 2; i < N; i++) {
            curr = Math.min(prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static int minJump(int[] heights, int N) {
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);
        return calcMinJump(heights, N, dp);

    }

    public static void main(String[] s) {
        System.out.println(minJump(new int[]{30, 10, 60, 10, 60, 50}, 5));
    }
}
