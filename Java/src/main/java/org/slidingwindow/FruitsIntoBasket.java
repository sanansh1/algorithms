package org.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitsIntoBasket {
    public static int findMaxFruitsBruteforce(int[] arr) {
        // bruite force
        // 2 for loops
        int maxlength = 0;
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> baskets = new HashSet<>();
            for (int j = i; j < arr.length; j++) {
                baskets.add(arr[j]);
                if (baskets.size() > 2) {
                    break;
                } else if (baskets.size() == 2) {
                    maxlength = Math.max(maxlength, j - i + 1);
                }
            }
        }
        return maxlength;
    }

    public static int findMaxFruitsSlidingWindow(int[] arr) {
        // bruite force
        // 2 for loops
        int maxlength = 0, left = 0, right = 0;

        Map<Integer, Integer> baskets = new HashMap<>();
        // expand window
        while (right < arr.length) {
            baskets.put(arr[right], baskets.getOrDefault(arr[right], 0) + 1);
            // shrink the window
            while (baskets.size() > 2) {
                baskets.put(arr[left], baskets.getOrDefault(arr[left], 0) - 1);
                if (baskets.get(arr[left]) == 0) {
                    baskets.remove(arr[left]);
                }
                left++;
            }
            if (baskets.size() == 2) maxlength = Math.max(maxlength, right - left + 1);
            right++;
        }

        return maxlength;
    }

    public static int findMaxFruitsSlidingWindowOptimized(int[] arr) {
        // bruite force
        // 2 for loops
        int maxlength = 0, left = 0, right = 0;

        Map<Integer, Integer> baskets = new HashMap<>();
        // expand window
        while (right < arr.length) {
            baskets.put(arr[right], baskets.getOrDefault(arr[right], 0) + 1);
            // shrink the window
            if (baskets.size() > 2) {
                baskets.put(arr[left], baskets.getOrDefault(arr[left], 0) - 1);
                if (baskets.get(arr[left]) == 0) {
                    baskets.remove(arr[left]);
                }
                left++;
            }
            if (baskets.size() == 2) maxlength = Math.max(maxlength, right - left + 1);
            right++;
        }

        return maxlength;
    }

    public static void main(String[] s) {
        System.out.println(findMaxFruitsBruteforce(new int[]{3, 3, 3, 1, 2, 11, 2, 3, 3, 4}));
        System.out.println(findMaxFruitsSlidingWindow(new int[]{3, 3, 3, 1, 2, 11, 2, 3, 3, 4}));
        System.out.println(findMaxFruitsSlidingWindowOptimized(new int[]{3, 3, 3, 1, 2, 11, 2, 3, 3, 4}));
    }
}
