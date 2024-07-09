package org.intuit;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // Creating a PriorityQueue with natural ordering (min-heap)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Adding elements to the PriorityQueue
        pq.add(10);
        pq.add(5);
        pq.add(15);
        pq.add(3);

        // Displaying the PriorityQueue (the head will be the smallest element)
        System.out.println("PriorityQueue elements:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll()); // Remove and return the head of the queue
        }
    }
}
