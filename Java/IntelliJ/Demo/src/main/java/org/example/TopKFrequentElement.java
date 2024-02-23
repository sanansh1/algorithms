package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement {
    public static int[] topKFrequentElements(int[] arr, int k) {
        if (arr.length == 0 || k > arr.length) {
            return new int[0];
        }
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int j : arr) {
            count.put(j, count.getOrDefault(j, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));
        for (Map.Entry<Integer, Integer> element : count.entrySet()) {
            pq.add(element.getKey());
            if (pq.size() > k) {
                pq.remove();
            }
        }
        int[] a = new int[pq.size()];
        for (int i = k-1; i >=0; i--) {
            a[i] = pq.poll();
        }
        return a;
    }

    public static void main(String[] s) {
        int[] top = topKFrequentElements(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println("Top K frequent elements");
        for (int j : top) {
            System.out.println(j);
        }
    }
}
