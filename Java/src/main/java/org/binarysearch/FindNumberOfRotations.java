package org.binarysearch;

public class FindNumberOfRotations {
    //arr = [4,5,6,7,0,1,2,3]
    public static int numberOfRotations(int[] a) {
        int index = 0;
        int low = 0, high = a.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (a[low] <= a[high]) {
                if (a[low] < mid) {
                    index = low;
                    return index;
                }
            }
            if (a[mid] >= a[low]) {
                index = low;
                low = mid + 1;
            } else if (a[mid] < a[high]) {
                index = mid;
                high = mid;
            }
        }
        return index;
    }

    public static void main(String[] s) {
        System.out.println(numberOfRotations(new int[]{4, 5, 6, 7, 0, 1, 2, 3}));
    }
}
