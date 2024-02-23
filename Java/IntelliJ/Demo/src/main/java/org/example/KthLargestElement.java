package org.example;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static int getKthLargest(int[] arr, int k) {
        if (arr.length == 0 || k > arr.length) {
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int j : arr) {
            pq.add(j);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq!=null?pq.peek():0;
    }

    public static void main(String[] s) {
        int k = getKthLargest(new int[]{7, 9, 3, 5, 2, 1, 7, 5}, 4);
        System.out.println("Kth Largest element - " + k);
    }
}
