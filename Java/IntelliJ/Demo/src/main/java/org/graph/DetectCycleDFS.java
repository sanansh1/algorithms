package org.graph;

import java.util.ArrayList;

public class DetectCycleDFS {

    public static boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = Boolean.TRUE;
        for (int n : adj.get(node)) {
            if (vis[n] == Boolean.FALSE) {
                if (dfs(n, node, adj, vis)) {
                    return Boolean.TRUE;
                }
            } else if (n != parent) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            vis[i] = Boolean.FALSE;
        }

        for (int i = 0; i < V; i++) {
            if (vis[i] == Boolean.FALSE) {
                if (dfs(i, -1, adj, vis)) return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public static void main(String[] s) {

    }
}
