package org.backtracking;

public class SudokuSolver {
    public static boolean solve(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '.') {
                    for (int val = 1; val <= 9; val++) {
                        if (isValid(grid, (char) val, i, j)) {
                            grid[i][j] = (char) val;
                            if (solve(grid)) {
                                return true;
                            } else {
                                grid[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] grid, char c, int i, int j) {
        for (int k = 0; k < 9; k++) {
            // row check
            if (grid[i][k] == c) {
                return false;
            }
            // column check
            if (grid[k][j] == c) {
                return false;
            }
            // 3*3 matrix check
            if (grid[3 * (i / 3) + i / 3][3 * (j / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] s) {
        char[][] board = {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
        boolean res = solve(board);
        System.out.println(res);
    }
}
