package org.heap;

import java.util.PriorityQueue;
import java.util.Queue;

//pramp
public class SortingKSortedArray {
    public static int[] sortedMessyK(int[] arr, int K) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        int i;
        for (i = 0; i <= K; i++) {
            minHeap.add(arr[i]);
        }
        int index = 0;
        while (i < arr.length) {
            arr[index] = minHeap.poll();
            index++;
            minHeap.add(arr[i]);
            i++;
        }
        while (index < arr.length) {
            arr[index] = minHeap.poll();
            index++;
        }
        return arr;
    }

    public static void main(String[] s) {
        int[] i = sortedMessyK(new int[]{4, 1, 5, 2, 6}, 2);
        for (int a : i) {
            System.out.print(a + " ");
        }
    }
}
