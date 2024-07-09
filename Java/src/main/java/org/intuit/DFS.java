package org.intuit;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static List<Integer> graphtraversal(int V, List<List<Integer>> adj) {
        int[] vis = new int[V];
        vis[0] = 1;
        List<Integer> res = new ArrayList<>();
        dfs(adj, 0, vis, V, res);
        return res;
    }

    static void dfs(List<List<Integer>> adj, int ind, int[] vis, int V, List<Integer> res) {
        vis[ind] = 1;
        res.add(ind);

        for (Integer i : adj.get(ind)) {
            if (vis[i] == 0) {
                dfs(adj, i, vis, V, res);
            }
        }
    }
}
