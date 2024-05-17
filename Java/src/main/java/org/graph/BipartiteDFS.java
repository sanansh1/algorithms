package org.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteDFS {
    public static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] color) {
        for (int neighbor : adj.get(node)) {
            int ncolor = color[neighbor];
            if (ncolor == -1) {
                color[neighbor] = 1 - color[node];
                dfs(neighbor, adj, color);
            } else if (color[neighbor] == color[node]) {
                return Boolean.FALSE;
            }

        }
        return Boolean.TRUE;
    }

    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for (int i = 0; i < V; i++) {
            color[i] = 0;
            if (!dfs(i, adj, color)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public static void main(String[] s) {

    }
}
