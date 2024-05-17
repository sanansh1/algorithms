package org.dynamicprogramming;

import java.util.Arrays;

// O(N), O(N)
public class Fibonacci {
    public static int fibonacci(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int fib = calculateFib(dp, n);
        return fib;
    }

    public static int calculateFib(int[] dp, int i) {
        if (i <= 1) {
            return i;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        dp[i] = calculateFib(dp, i - 1) + calculateFib(dp, i - 1);
        return dp[i];
    }

    public static void main(String[] s) {
        System.out.println(fibonacci(3));
    }
}
