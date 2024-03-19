package org.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSortDFS {

    public static int[] isTopologicalSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Arrays.fill(vis, 0);
        // Container for topological sorted numbers
        Stack<Integer> result = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(V, adj, i, vis, result);
            }
        }
        int[] resultArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.pop();
        }
        return resultArr;
    }

    private static void dfs(int v, ArrayList<ArrayList<Integer>> adj, int node, int[] vis, Stack<Integer> s) {
        vis[node] = 1;
        for (int neighbor : adj.get(node)) {
            if (vis[neighbor] == 0) {
                dfs(v, adj, neighbor, vis, s);
            }
        }
        s.add(node);
    }

    public static void main(String[] s) {

    }
}
