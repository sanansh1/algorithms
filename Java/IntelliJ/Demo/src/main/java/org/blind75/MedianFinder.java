package org.blind75;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    private final Queue<Integer> smallHeap;
    private final Queue<Integer> largeHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a, b) -> b - a);
        largeHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public static void main(String[] s) {

    }

    public void addNum(int a) {
        smallHeap.add(a);
        if (smallHeap.size() - largeHeap.size() > 1 ||
                !largeHeap.isEmpty() &&
                        smallHeap.peek() > largeHeap.peek()) {
            largeHeap.add(smallHeap.poll());
            if (largeHeap.size() - smallHeap.size() > 1) {
                smallHeap.add(largeHeap.poll());
            }
        }
    }
}
