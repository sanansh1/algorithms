package org.SDESheet;

public class IsArraySorted {
    public static boolean isSorted(int[] arr) {
        int prev = arr[0];
        boolean ascending = true, descending = true;
        for (int i = 1; i < arr.length; i++) {
            if (prev > arr[i]) {
                ascending = false;
            }
            if (prev < arr[i]) {
                descending = false;
            }
        }
        return ascending || descending;
    }

    public static void main(String[] s) {
        System.out.println(isSorted(new int[]{30, 20, 16, 11, 10, 10}));
    }
}
