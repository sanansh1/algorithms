package org.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFS {
    public static int[] topSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        Arrays.fill(indegree, 0);
        for (int i = 0; i < V; i++) {
            for (int node : adj.get(i)) {
                indegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int in : indegree) {
            if (in == 0) {
                queue.add(in);
            }
        }
        int[] topo = new int[V];
        int i = 0;
        while (!queue.isEmpty()) {
            int node = queue.peek();
            queue.remove();
            topo[i++] = node;
            for (int ad : adj.get(node)) {
                indegree[ad]--;
                if (indegree[ad] == 0) {
                    queue.add(ad);
                }
            }
        }
        return topo;
    }

    public static void main(String[] s) {

    }
}
