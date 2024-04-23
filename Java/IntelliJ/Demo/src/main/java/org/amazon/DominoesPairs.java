package org.amazon;

import java.util.HashMap;
import java.util.Map;

public class DominoesPairs {

    public static void main(String[] s) {
        System.out.println(numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {1, 1}, {5, 6}}));
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int pairsCountSum = 0;
        Map<Integer, Integer> pairsCount = new HashMap<>();
        for (int[] domino : dominoes) {
            int up = Math.min(domino[0], domino[1]);
            int down = Math.max(domino[0], domino[1]);

            int num = up * 10 + down;
            if (!pairsCount.containsKey(num)) {
                pairsCount.put(num, 1);
            } else {
                System.out.println(pairsCountSum);
                pairsCountSum += pairsCount.get(num);
                pairsCount.put(num, pairsCount.get(num) + 1);
            }
        }

        return pairsCountSum;

    }
}
