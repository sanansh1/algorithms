package org.blind75;

/**
 * Problem Statement: Given an integer array arr of size N, sorted in ascending order
 * (with distinct values) and a target value k. Now the array is rotated at some pivot point unknown to you.
 * Find the index at which k is present and if k is not present return -1.
 */
public class SearchInRotatedSortedArray {
    public static int findElement(int[] arr, int K) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == K) {
                return mid;
            } else if (arr[l] <= arr[mid] && (K > arr[mid] || K < arr[l])) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] s) {
        int[] arr = {4, 5, 6, 7, 1, 2, 3};
        int ans = findElement(arr, 3);
        System.out.println("The minimum element is: " + ans);
    }
}
