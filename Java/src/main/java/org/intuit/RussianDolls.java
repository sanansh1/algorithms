package org.intuit;

import java.util.Arrays;
import java.util.PriorityQueue;

public class RussianDolls {

    public static int minNumberOfSets(int[] dolls) {
        // Step 1: Sort the dolls by size
        Arrays.sort(dolls);

        // Step 2: Use a priority queue (min-heap) to track the top dolls in each set
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Step 3: Iterate over each doll and place it in the first set where it fits
        for (int doll : dolls) {
            if (!minHeap.isEmpty() && minHeap.peek() < doll) {
                // If the smallest top doll can accommodate the current doll
                minHeap.poll(); // Remove the smallest top doll
            }
            // Place the current doll as the new top doll of the set
            minHeap.offer(doll);
        }

        // The size of the min-heap is the number of sets needed
        return minHeap.size();
    }

    public static void main(String[] args) {
        int[] dolls1 = {5, 4, 6, 3, 7};
        int[] dolls2 = {1, 2, 3, 4, 5};
        int[] dolls3 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] dolls4 = {3, 3, 3, 3};

        System.out.println("Minimum number of sets for dolls1: " + minNumberOfSets(dolls1)); // Expected: 2
        System.out.println("Minimum number of sets for dolls2: " + minNumberOfSets(dolls2)); // Expected: 1
        System.out.println("Minimum number of sets for dolls3: " + minNumberOfSets(dolls3)); // Expected: 1
        System.out.println("Minimum number of sets for dolls4: " + minNumberOfSets(dolls4)); // Expected: 4
    }
}
