package org.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    public static List<List<Integer>> backtrack(List<List<Integer>> res, List count, int[] nums) {
        if (res.size() == nums.length) {
            //return res.toArray()
        }
        return res;
    }

    public static void main(String[] s) {

    }
}
