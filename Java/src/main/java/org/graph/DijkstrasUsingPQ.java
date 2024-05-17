package org.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasUsingPQ {

    public static void main(String[] s) {
    
    }

    public static int[] minDistance(int V, ArrayList<ArrayList<Integer>> adj, int S) {
        int[] distArray = new int[V];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        pq.add(new Pair(S, 0));
        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int nDist = pq.peek().distance;
            pq.remove();
            for (int adjNode : adj.get(node)) {
                int edgeWeight = adj.get(adjNode).get(1);
                if (nDist + edgeWeight < distArray[adjNode]) {
                    distArray[adjNode] = nDist + edgeWeight;
                    pq.add(new Pair(adjNode, distArray[adjNode]));
                }
            }
        }
        return distArray;
    }

    private static class Pair {
        int node;
        int distance;

        public Pair(int node, int distance) {
            node = node;
            distance = distance;
        }

    }
}
