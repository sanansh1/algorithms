package org.intuit;

import org.blind79.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static int rottenOranges(int[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        /*List<List<Integer>> adjList = new ArrayList<>();
        for (int[] edge : grid) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : grid) {
            adjList.get(edge[0]).add(edge[1]);
        }*/
        int n = grid.length, cntFresh = 0;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    vis[i][j] = 2;
                    q.add(new Pair(i, j, 0));
                } else {
                    vis[i][j] = 0;
                }
                if (grid[i][j] == 1) {
                    cntFresh++;
                }
            }
        }

        int tm = 0, cnt = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            tm = Math.max(tm, t);
            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 2) {
                    q.add(new Pair(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }
        if (cnt != cntFresh) {
            return -1;
        }
        return tm;
    }
}
