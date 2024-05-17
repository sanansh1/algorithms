package org.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BidirectionalGraphCycleDFS {

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        Arrays.fill(vis, 0);
        Arrays.fill(pathVis, 0);
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (getCheckBfs(V, adj, i, pathVis, vis) == Boolean.TRUE) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    private static Boolean getCheckBfs(int v, ArrayList<ArrayList<Integer>> adj, int node, int[] pathVis, int[] vis) {
        vis[node] = 1;
        pathVis[node] = 1;
        for (int neighbor : adj.get(node)) {
            if (vis[neighbor] == 0) {
                if (getCheckBfs(v, adj, neighbor, pathVis, vis) == Boolean.TRUE) {
                    return Boolean.TRUE;
                }
            } else if (pathVis[neighbor] == 1) {
                return Boolean.TRUE;
            }
        }
        pathVis[node] = 0;
        return Boolean.FALSE;
    }

    public static void main(String[] s) {

    }
}
