package org.greedy;

import java.util.Arrays;
import java.util.List;

public class MinTotatlCost {
    public static int totalCost(List<Integer> arr) {
        int n = arr.size();
        int total = 0;
        for (int ii = 0; ii < n - 1; ++ii) {
            total += Math.abs(arr.get(ii + 1) - arr.get(ii));
        }
        return total;
    }

    public static void main(String[] s) {
        System.out.println(totalCost(Arrays.asList(1, 2, 1, 5)));
    }
}
