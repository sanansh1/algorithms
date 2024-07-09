package org.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
public class FindLeastNumberOfUniqAfterKPops {

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> mapCount = new HashMap<>();
        for (int n : arr) {
            mapCount.put(n, mapCount.getOrDefault(n, 0) + 1);
        }
        int elementsRemoved = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(mapCount.values());

        while (!pq.isEmpty()) {
            elementsRemoved += pq.peek();
            if (elementsRemoved > k) {
                return pq.size();
            }
            pq.poll();
        }
        return 0;
    }
}
