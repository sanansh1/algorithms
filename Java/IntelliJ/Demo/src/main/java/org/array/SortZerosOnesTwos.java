package org.array;

/*
Sort an array of 0's 1's & 2's | Intuition of Algo
1. Sort array using merge sort - O(NlogN)
2. In one pass Count number of zeros, number of 1s,
number of 2s. In next pass insert number of zeros count, number of 1s count, number of 2s count. O(2N)
3. create low, mid and high pointers. O(N)
 */
public class SortZerosOnesTwos {
    public static void sortInPlace(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        System.out.println(" sorting:");
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(low, mid, arr);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                //System.out.println(":::" + arr[high]);
                swap(mid, high, arr);
                high--;
            }

        }
        for (int i : arr)
            System.out.print(i);
    }

    public static void swap(int left, int right, int[] arr) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] s) {
        sortInPlace(new int[]{1, 1, 2, 0, 0, 2});
    }
}
