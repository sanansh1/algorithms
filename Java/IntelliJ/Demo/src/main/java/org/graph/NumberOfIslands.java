package org.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static int numberOfIslands(char[][] grid) {
        int noOfIslands = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    noOfIslands += 1;
                    bfs(i, j, vis, grid);
                }
            }
        }

        return noOfIslands;
    }

    public static void bfs(int row, int col, int[][] vis, char[][] grid) {
        vis[row][col] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));

        while (!queue.isEmpty()) {
            int rowIndex = queue.peek().row;
            int colIndex = queue.peek().col;
            queue.remove();
            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    int actRow = row + delRow;
                    int actCol = col + delCol;
                    if (vis[row][col] == 0 && actRow >= 0 && actRow < grid.length && actCol >= 0 && actCol < grid[0].length && grid[actRow][actCol] == 1) {
                        vis[actRow][actCol] = 1;
                        queue.add(new Pair(actRow, actCol));
                    }
                }
            }

        }
    }

    public static void main(String[] s) {

    }

    static class Pair {
        int row;
        int col;


        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


}
