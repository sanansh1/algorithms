package org.array;

public class MaxCards {
    public static void main(String[] s) {

    }

    public static int maxPoints(int[] arr, int k) {
        int lSum = 0, rSum = 0, maxSum = 0;
        for (int i = 0; i < k; i++) {
            lSum += arr[i];
            maxSum = Math.max(maxSum, lSum);
        }

        int rPtr = arr.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            lSum -= arr[i];
            rSum += arr[rPtr--];
            maxSum = Math.max(maxSum, lSum + rSum);
        }
        return maxSum;
    }
}
