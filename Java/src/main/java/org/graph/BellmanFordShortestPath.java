package org.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordShortestPath {

    public static int[] shortestPath(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                if (distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]) {
                    distance[v] = distance[u] + v;
                }
            }
        }
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);
            if (distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]) {
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }

        }
        return distance;
    }

    public static void main(String[] s) {

    }
}
