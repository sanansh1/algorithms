package org.blind75;

// optimal O(N)
public class MaximumProdSubArray {
    public static int maxProdSubArray(int[] arr) {
        int pref = 1, suff = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[0] == 0) {
                pref = 1;
                suff = 1;
            } else {
                pref = pref * arr[i];
                suff = suff * arr[arr.length - i - 1];
            }
            max = Math.max(max, Math.max(pref, suff));
        }
        return max;
    }

    public static void main(String[] s) {
        int[] arr = {1, 2, -3, 0, -4, -5};
        int answer = maxProdSubArray(arr);
        System.out.println("The maximum product subarray is: " + answer);
    }
}
