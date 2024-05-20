package org.blind79;

public class FindPeakElement {
    public static int findPeakInSortedShiftedArray(int[] arr) {
        int low = 0, high = arr.length - 1, max = Integer.MIN_VALUE, mid = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[low] <= arr[mid]) {
                max = Math.max(max, arr[mid]);
                low = mid + 1;
            } else {
                max = Math.max(max, arr[high]);
                high = mid - 1;
            }
        }
        return max;
    }

    public static void main(String[] s) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
        System.out.print(findPeakInSortedShiftedArray(arr));
    }
}
