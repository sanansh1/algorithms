package org.blind79;

public class MaxSubArraySum {
    public static int maxSubarraySum(int[] nums, int n) {
        int maxSum = Integer.MIN_VALUE, curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum >= maxSum) {
                maxSum = curSum;
            }
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] s) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        int maxSum = maxSubarraySum(arr, n);
        System.out.println("The maximum subarray sum is: " + maxSum);
    }
}
