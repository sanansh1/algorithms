package org.graph;

import java.util.*;

public class GraphValidTree {

    public static boolean validTree(int n, int[][] edges) {
        if (n <= 0) {
            return false;
        }
        if (n - 1 != edges.length) {
            return false;
        }
        List<List<Integer>> adjacencyList = new ArrayList<>();
        // initialize adjacency list
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        stack.push(0);
        visited.add(0);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int neighbour : adjacencyList.get(node)) {
                if (visited.contains(neighbour)) {
                    continue;
                }
                visited.add(neighbour);
                stack.push(neighbour);
            }
        }

        return visited.size() == n;

    }

    public static void main(String[] s) {

    }
}
