package org.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {
    public static int timeTakenToRottenOranges(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        int cntFresh = 0;
        int tm = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                if (grid[i][j] == 1) {
                    cntFresh++;
                }
            }

            int drow[] = {-1, 0, +1, 0};
            int dcol[] = {0, 1, 0, -1};
            int cnt = 0;
            while (!queue.isEmpty()) {
                int r = queue.peek().row;
                int c = queue.peek().col;
                int t = queue.peek().time;
                tm = Math.max(tm, t);
                queue.remove();
                for (int k = 0; k < 4; k++) {
                    int nrow = r + drow[k];
                    int ncol = c + dcol[k];
                    if (nrow > 0 && nrow < n && ncol > 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                        vis[nrow][ncol] = 2;
                        queue.add(new Pair(nrow, ncol, t + 1));
                        cnt++;
                    }
                }
            }
            if (cntFresh != cnt) return -1;

        }
        return tm;
    }

    public static void main(String[] s) {

    }

    static class Pair {
        int row;
        int col;
        int time;

        Pair(int r, int c, int t) {
            row = r;
            col = c;
            time = t;
        }
    }
}
