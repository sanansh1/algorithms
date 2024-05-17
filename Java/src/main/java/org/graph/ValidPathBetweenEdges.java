package org.graph;

import java.util.*;

public class ValidPathBetweenEdges {

    public static boolean validPathBFS(int n, int[][] edges, int source, int destination) {
        // store all edges in graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], val -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], val -> new ArrayList<>()).add(edge[0]);

        }
        // store all the nodes
        boolean[] seen = new boolean[n];
        seen[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == destination) {
                return true;
            }
            //
            for (int neighbour : graph.get(node)) {
                if (!seen[neighbour]) {
                    seen[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
        return false;
    }

    public static boolean validPathDFS(int n, int[][] edges, int source, int destination) {
        // store all edges in graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], val -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], val -> new ArrayList<>()).add(edge[0]);

        }

        boolean[] seen = new boolean[n];

        return false;
    }
}
