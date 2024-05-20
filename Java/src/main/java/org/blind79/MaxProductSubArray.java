package org.blind79;

/**
 * calculate left product, right product, if current prod is 0, reset prod to 1.
 * Return max of left or right product
 */
public class MaxProductSubArray {

    public static int maxProdSubArray(int[] arr) {
        int maxP = Integer.MIN_VALUE, leftprod = 1, rightP = 1;
        for (int i = 0; i < arr.length; i++) {
            leftprod = leftprod * arr[i];
            rightP = rightP * arr[arr.length - i - 1];
            if (leftprod == 0) {
                leftprod = 1;
            }
            if (rightP == 0) {
                rightP = 1;
            }
            maxP = Math.max(maxP, Math.max(leftprod, rightP));
        }
        return maxP;
    }

    public static void main(String[] s) {
        int[] arr = {1, 2, -3, 0, -4, -5};
        int answer = maxProdSubArray(arr);
        System.out.println("The maximum product subarray is: " + answer);
    }
}
