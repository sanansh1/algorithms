package org.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleBFS {
    public static boolean courseSchedule(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int ad : adj.get(i)) {
                indegree[ad]++;
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
        return topo.length == V ? Boolean.TRUE : Boolean.FALSE;

    }

    public static void main(String[] s) {

    }
}
