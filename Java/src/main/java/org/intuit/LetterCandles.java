package org.intuit;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LetterCandles {
    public static int cost(String arr, int m) {
        Map<Character, Integer> mapCount = new HashMap<>();
        for (char c : arr.toCharArray()) {
            mapCount.put(c, mapCount.getOrDefault(c, 0) + 1);
        }
        // Create a priority queue to sort by the counts in descending order
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );

        // Add all entries from the map to the priority queue
        pq.addAll(mapCount.entrySet());
        int cost = 0;
        for (int count : mapCount.values()) {
            cost += count * count;
        }
        while (m > 0 && !pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            System.out.println("Character: " + entry.getKey() + ", Count: " + entry.getValue());
            int count = entry.getValue();
            if (count > 0) {
                cost -= count * count;
                int newCount = count - 1;
                m--; // Decrease m
                cost += newCount * newCount;
                if (newCount > 0) {
                    entry.setValue(newCount);
                    pq.offer(entry);
                }
            }

        }
        return cost;

    }
}
