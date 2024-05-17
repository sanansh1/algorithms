package org.graph;

import java.util.Arrays;

public class NumberOfIslandsDFS {
    public int numberOfIslands(int[][] grid) {
        int countOfIslands = 0;
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        for (int[] row : vis) {
            Arrays.fill(row, 0);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    dfs(i, j, vis, grid);
                    countOfIslands += 1;
                }
            }
        }
        return countOfIslands;
    }
/*
     0 1 2 3 4 5
  0  0 0 0 1 0 1
  1  1 0 0 1 1 1
  2  1 0 1 0 0 0
   */

    public void dfs(int row, int col, int[][] vis, int[][] grid) {
        vis[row][col] = 1;
        int n = grid.length, m = grid[0].length;
        // explore path
        for (int delRow = -1; delRow <= 1; delRow++) {
            for (int delCol = -1; delCol <= 1; delCol++) {
                int actRow = row + delRow; //
                int actCol = col + delCol; // 3
                if (actRow >= 0 && actRow < n && actCol >= 0 && actCol < m && grid[actRow][actCol] == 1 && vis[actRow][actCol] == 0) {
                    dfs(actRow, actCol, vis, grid);
                }
            }
        }
    }
}
