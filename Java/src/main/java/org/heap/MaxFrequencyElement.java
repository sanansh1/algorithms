package org.heap;

import java.util.*;

public class MaxFrequencyElement {

    public static int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> mapCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mapCount.put(nums[i], mapCount.getOrDefault(nums[i], 0) + 1);
        }
        // priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> mapCount.get(b) - mapCount.get(a));
        for (Map.Entry<Integer, Integer> e : mapCount.entrySet()) {
            pq.offer(e.getKey());
        }
        return pq.poll();
    }

    public static int countMaxFrequencyElements(int[] nums) {
        Map<Integer, Integer> mapCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mapCount.put(nums[i], mapCount.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> list = new ArrayList(mapCount.values());
        Collections.sort(list, Collections.reverseOrder());
        int sum = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) == list.get(i)) {
                sum += list.get(i);
            } else {
                return sum;
            }
        }
        // priority queue
        return sum;
    }

    public static void main(String[] s) {
        System.out.println("3, 1, 8, 1, 3, 1, 4");
        int a = maxFrequencyElements(new int[]{3, 1, 8, 1, 3, 1, 4});
        System.out.println("Max frequency: " + a);
        System.out.println("3, 1, 8, 1, 3, 1, 4");
        int b = countMaxFrequencyElements(new int[]{3, 1, 8, 1, 3, 1, 4});
        System.out.println("Count Max frequency: " + b);
    }
}
