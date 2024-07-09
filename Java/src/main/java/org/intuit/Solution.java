package org.intuit;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {1, 5, 8, 10};
        int n = arr.length;
        int k = 2;

        int result = solution.getMinDiff(arr, n, k);
        System.out.println("Minimum difference is: " + result); // Output: 5
    }

    public int getMinDiff(int[] arr, int n, int k) {
        // Sort the array
        Arrays.sort(arr);

        // Initial difference between the highest and lowest elements
        int diff = arr[n - 1] - arr[0];

        // Initial minimum and maximum values after the height adjustment
        int minVal = arr[0] + k;
        int maxVal = arr[n - 1] - k;

        // Variables to store the current smallest and largest values
        int small, big;

        for (int i = 0; i < n - 1; i++) {
            small = Math.min(minVal, arr[i + 1] - k); // Adjust the next tower height by decreasing k
            big = Math.max(maxVal, arr[i] + k); // Adjust the current tower height by increasing k

            // Ignore cases where the adjusted height is negative
            if (small < 0) {
                continue;
            }

            // Update the minimum difference
            diff = Math.min(diff, big - small);
        }

        return diff;
    }
}
