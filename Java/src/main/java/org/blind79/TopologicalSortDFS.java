package org.blind79;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSortDFS {
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Arrays.fill(vis, 0);
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, st, adj);
            }
        }

        int[] ans = new int[V];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.peek();
            st.pop();
        }
        return ans;
    }

    public static void dfs(int ind, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[ind] = 1;
        for (int neigbour : adj.get(ind)) {
            if (vis[neigbour] == 0) {
                dfs(neigbour, vis, st, adj);
            }
        }
        st.push(ind);
    }
}
