package org.amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverage {
    static int size, windowSum = 0, count = 0;
    static Deque queue = new ArrayDeque<Integer>();

    public MovingAverage(int size) {
        MovingAverage.size = size;
    }

    public static void main(String[] s) {
        MovingAverage move = new MovingAverage(2);
        System.out.println(next(1));
        System.out.println(next(10));
        System.out.println(next(10));
        System.out.println(next(5));
    }

    public static double next(int val) {
        ++count;
        // calculate the new sum by shifting the window
        queue.add(val);
        int tail = count > size ? (int) queue.poll() : 0;
        windowSum = windowSum - tail + val;
        int min = Math.min(size, count);
        return windowSum * 1.0 / min;
    }
}
