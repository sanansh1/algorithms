package org.graph;

import java.util.ArrayList;

public class AlienDictionary {

    public static char[] alienDictionary(String[] dict, int K, int N) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < N - 2; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    edges.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }
        // then find out topo sort
        return null;
    }

    public static void main(String[] s) {

    }
}
