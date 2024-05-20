package org.blind79;

public class FindMinInSortedShiftedArray {
    public static int minInSortedShiftedArray(int[] arr) {
        int low = 0, high = arr.length - 1, min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[low] <= arr[mid]) {
                min = Math.min(min, arr[low]);
                low = mid + 1;
            } else {
                min = Math.min(min, arr[mid]);
                high = mid - 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int ans = minInSortedShiftedArray(arr);
        System.out.println("The minimum element is: " + ans);
    }
}
