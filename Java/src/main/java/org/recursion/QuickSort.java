package org.recursion;

public class QuickSort {

    public static void main(String[] s) {
        int[] arr = new int[]{4, 6, 2, 5, 7, 9, 1, 3};
        int[] a = quicksort(arr);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        System.out.println("pivot:" + pivot + "low:" + low + "high:" + high);
        int i = low;
        int j = high;

        while (i < j) {
            System.out.println(i + ":" + j);
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }
            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }

    public static void qs(int[] arr, int low, int high) {
        if (low < high) {
            int partitionKey = partition(arr, low, high);
            System.out.println("partitionKey" + partitionKey);
            qs(arr, low, partitionKey - 1);
            qs(arr, partitionKey + 1, high);
        }
    }

    public static int[] quicksort(int[] arr) {
        // get the partition key/pivot index
        // move elements less to left and more to right
        // until all elements are sorted
        //int pivot = partition(arr, )
        qs(arr, 0, arr.length - 1);
        return arr;
    }
}
