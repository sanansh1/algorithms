package org.blind75;

public class MaximumSumSubArray {
    public static int maxSumSubArrayBruteforce(int[] a) {
        // brute force
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum + a[k];
                }
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    public static int maxSumSubArrayBetter(int[] a) {
        // brute force
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum = sum + a[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    public static int maxSumSubArrayOptimal(int[] a) {
        // brute force
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] s) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        int maxSum = maxSumSubArrayBruteforce(arr);
        System.out.println("The maximum subarray sum is: " + maxSum);
        int max = maxSumSubArrayBetter(arr);
        System.out.println("The maximum subarray sum better approach is: " + max);
        System.out.println("The maximum subarray sum optimal approach is: " + maxSumSubArrayOptimal(arr));

    }
}
