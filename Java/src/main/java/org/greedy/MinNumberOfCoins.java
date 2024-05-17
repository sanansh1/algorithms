package org.greedy;

import java.util.ArrayList;
import java.util.List;

public class MinNumberOfCoins {
    public static List<Integer> minNumberOfCoins(int[] coins, int V) {
        List<Integer> ans = new ArrayList<>();
        // loop from end to beginning
        for (int i = coins.length - 1; i > 0; i--) {
            // subtract from coin until denomination is greater than the coin change.
            while (V > coins[i]) {
                V = V - coins[i];
                ans.add(coins[i]);
            }
        }
        return ans;
    }
}
