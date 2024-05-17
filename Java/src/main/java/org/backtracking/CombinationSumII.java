package org.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void findCombSum(int[] arr, int ind, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) {
                continue;
            }
            if (arr[i] > target) {
                break;
            }
            ds.add(arr[i]);
            findCombSum(arr, i + 1, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }

    public static List<List<Integer>> combSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        findCombSum(arr, 0, target, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] s) {
        int[] v = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> ans = combSum(v, 8);
        System.out.println(ans.toString().replace(",", " "));
    }
}
