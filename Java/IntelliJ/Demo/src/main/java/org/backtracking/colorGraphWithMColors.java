package org.backtracking;

import java.util.List;

public class colorGraphWithMColors {
    public static boolean graphColoring(List<Integer> G, int[] color, int m) {
        int n = G.size();
        return solve(0, G, color, m);
    }

    public static boolean solve(int node, List<Integer> G, int[] color, int m) {
        return node == G.size();
        //for()
    }

    public static void main(String[] s) {

    }
}
