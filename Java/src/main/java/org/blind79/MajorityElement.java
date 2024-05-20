package org.blind79;

import java.util.*;

public class MajorityElement {
    public static void main(String[] s) {
        int[] arr = {11, 33, 33, 11, 33, 11};
        List<Integer> ans = getMajorityElement(arr);
        System.out.print("The majority elements are: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }

    public static List<Integer> getMajorityElement(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
            if (countMap.get(arr[i]) > arr.length / 3) {
                set.add(arr[i]);
            }
        }
        return new ArrayList<>(set.stream().toList());
    }
}
