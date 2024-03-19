package org.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {

    public static void dfs(int row, int col, int[][] vis, int[][] grid,
                           ArrayList<String> islands, int row0, int col0) {
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        islands.add(row - row0 + " " + (col - col0));
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int mcol = col + dcol[i];
            if (nrow >= 0 && nrow < n && mcol >= 0 && mcol < m && vis[nrow][mcol] == 0 && grid[nrow][mcol] == 1) {
                dfs(nrow, mcol, vis, grid, islands, row0, col0);
            }
        }
    }

    public static int countNumberOfDisIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Set<ArrayList<String>> set = new HashSet<>();
        int[][] vis = new int[n][m];
        // loop over
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    ArrayList<String> islands = new ArrayList<>();
                    dfs(i, j, vis, grid, islands, i, j);
                    set.add(islands);
                }
            }
        }
        return set.size();
    }

    public static void main(String[] s) {

    }
}
