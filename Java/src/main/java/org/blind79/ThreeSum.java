package org.blind79;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    public static List<List<Integer>> triplet(int n, int[] arr) {
        Set<List<Integer>> st = new HashSet<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(arr[i] + arr[j]);
                if (hashSet.contains(third)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    temp.sort(null);
                    st.add(temp);
                } else {
                    hashSet.add(arr[j]);
                }
            }
        }
        return st.stream().toList();
    }

    public static List<List<Integer>> tripletOptimized(int n, int[] arr) {
        Set<List<Integer>> st = new HashSet<>();
        int len = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < len; i++) {
            if (i != 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int j = i + 1, k = len - 1;
            while (j < k) {

                int target = arr[i] + arr[j] + arr[k];
                if (target == 0) {
                    List<Integer> list = Arrays.asList(arr[i], arr[j], arr[k]);
                    st.add(list);
                    k--;
                    j++;
                    while (j < k && arr[j] == arr[j - 1]) {
                        j++;
                    }
                    while (j < k && arr[k] == arr[k - 1]) {
                        k--;
                    }
                } else if (target > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return st.stream().toList();
    }


    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int n = arr.length;
        List<List<Integer>> ans = triplet(n, arr);
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
        ans = tripletOptimized(n, arr);
        ans.stream()
                .forEach(subList -> {
                    subList.forEach(System.out::print);
                    System.out.println(" ");
                });

        System.out.println();
    }
}
