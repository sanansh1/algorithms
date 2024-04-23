package org.SDESheet;

// O(N)
public class SecondLargestSmallestInArray {
    public static int secondLargest(int[] arr, int n) {
        int largest = arr[0], sLargest = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                sLargest = largest;
                largest = arr[i];
            } else if (arr[i] > sLargest && arr[i] < largest) {
                sLargest = arr[i];
            }
        }
        return sLargest;
    }

    public static int secondSmallest(int[] arr, int n) {
        int smallest = arr[0], sSmallest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) {
                sSmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] < sSmallest && arr[i] > smallest) {
                sSmallest = arr[i];
            }
        }
        return sSmallest;
    }

    public static void main(String[] s) {
        System.out.println(secondLargest(new int[]{6, 8, 9, 3, 6, 2}, 6));
        System.out.println(secondSmallest(new int[]{6, 8, 9, 3, 6, 2}, 6));
    }
}
