package org.blind75;

/**
 * Given an integer array arr of size N, sorted in ascending order (with distinct values). Now
 * the array is rotated between 1 to N times which is unknown.
 * Find the minimum element in the array.
 */
public class FindMinInRotatedSortedArray {
    // [2,3,0,1]
    public static int findMin(int[] a) {
        int l = 0, r = a.length - 1;
        int ans = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[l] <= a[mid]) {
                ans = Math.min(ans, a[l]);
                l = mid + 1;

            } else if (a[r] > a[mid]) {
                ans = Math.min(ans, a[mid]);
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] s) {
        int[] arr = {4, 5, 6, 7, 1, 2, 3};
        int ans = findMin(arr);
        System.out.println("The minimum element is: " + ans);
    }
}
