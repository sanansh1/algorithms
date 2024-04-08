package org.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
    public static void combinationSum(ArrayList<Integer> arr, int ind, int sum, ArrayList<Integer> res) {
        if (ind == arr.size()) {
            res.add(sum);
            return;
        }
        combinationSum(arr, ind + 1, sum + arr.get(ind), res);
        combinationSum(arr, ind + 1, sum, res);
    }

    public static List<Integer> noOfWays(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> res = new ArrayList<>();
        combinationSum(arr, 0, 0, res);
        Collections.sort(res);
        return res;
    }

    public static void main(String[] s) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(2);
        List<Integer> res = noOfWays(arr, arr.size());
        System.out.println(res);
    }
}
