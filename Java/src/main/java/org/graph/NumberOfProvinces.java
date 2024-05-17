package org.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfProvinces {

    public static int getNumberOfProvinces(List<List<Integer>> edges, int V) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (List<Integer> edge : edges) {
            adjList.add(new ArrayList<Integer>());
        }
        for (List<Integer> edge : edges) {
            adjList.get(edge.get(0)).add(edge.get(1));
            adjList.get(edge.get(1)).add(edge.get(0));
        }

        int noOfProv = 0;
        if (V == 0) {
            return 0;
        } else if (V == 1) {
            return 1;
        }
        boolean[] vis = new boolean[V + 1];
        for (int i = 0; i <= V; i++) {
            if (vis[i] == Boolean.FALSE) {
                noOfProv += 1;
                dfs(i, vis, adjList);
            }
        }
        return noOfProv;
    }

    private static void dfs(int node, boolean[] vis, List<List<Integer>> adjList) {
        vis[node] = Boolean.TRUE;
        for (int neighbour : adjList.get(node)) {
            if (vis[neighbour] == Boolean.FALSE) {
                dfs(neighbour, vis, adjList);
            }
        }
    }


    public static void main(String[] s) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(2, 1));
        edges.add(Arrays.asList(3, 4));
        //[[0,1],[1,2],[3,4]]
        int n = getNumberOfProvinces(edges, 5);
        System.out.println(n);
    }
}
