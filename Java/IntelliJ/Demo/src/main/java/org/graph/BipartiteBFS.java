package org.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteBFS {
    /*
    for each of the node, starting from src node, push the first element to queue, then color it with 0,
    pop it check adj list, get the color, color it with alternate color, push to queue,
    if node colr and adj color is same, return false

     */
    public static boolean bfs(int node, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int n = q.peek();
            q.remove();
            for (int neighbour : adj.get(n)) {
                int ncolor = color[neighbour];
                if (ncolor == -1) {
                    color[neighbour] = 1 - color[n];
                    q.add(neighbour);
                } else if (color[n] == color[neighbour]) {
                    return Boolean.FALSE;
                }

            }
        }
        return Boolean.TRUE;
    }

    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for (int i = 0; i < V; i++) {
            color[i] = 0;
            if (bfs(i, adj, color) == Boolean.FALSE)
                return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static void main(String[] s) {

    }
}
