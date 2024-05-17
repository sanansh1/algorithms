package org.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleBFS {

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            vis[i] = Boolean.FALSE;
        }

        for (int i = 0; i < V; i++) {
            if (vis[i] == Boolean.FALSE) {
                if (detectCycle(V, adj, i, vis))
                    return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private static Boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj, int src, boolean[] vis) {
        Queue<Pair> queue = new LinkedList<>();
        vis[src] = Boolean.TRUE;
        queue.add(new Pair(-1, src));
        while (!queue.isEmpty()) {
            int node = queue.peek().node;
            int parent = queue.peek().parent;
            queue.remove();
            for (Integer neighbour : adj.get(node)) {
                if (vis[neighbour] == Boolean.FALSE) {
                    queue.add(new Pair(node, neighbour));
                    vis[neighbour] = Boolean.TRUE;
                } else if (vis[neighbour] == Boolean.TRUE && neighbour != parent) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    public static void main(String[] s) {

    }

    static class Pair {
        int parent;
        int node;

        Pair(int p, int n) {
            parent = p;
            node = n;
        }
    }

}
