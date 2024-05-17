package org.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsBFS {
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
        ArrayList<ArrayList<Character>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<Character>());
        }
        adj.get('0').add('1');
        adj.get('1').add('0');
        adj.get('0').add('4');
        adj.get('4').add('0');
        adj.get('1').add('2');
        adj.get('2').add('1');
        adj.get('1').add('3');
        adj.get('3').add('1');
        System.out.println(adj);
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
