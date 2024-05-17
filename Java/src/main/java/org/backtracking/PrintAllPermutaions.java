package org.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutaions {
    public static List<List<Integer>> permute(int[] n) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] freq = new boolean[n.length];
        calcPermute(n, freq, res, new ArrayList<>());
        return res;
    }

    public static void calcPermute(int[] n, boolean[] freq, List<List<Integer>> res, List<Integer> ds) {
        if (ds.size() == n.length) {
            res.add(ds);
            return;
        }
        for (int i = 0; i < n.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(i);
                calcPermute(n, freq, res, ds);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }

    public static void main(String[] s) {

    }
}
