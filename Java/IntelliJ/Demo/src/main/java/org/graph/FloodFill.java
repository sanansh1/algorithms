package org.graph;

public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        int initColor = image[sr][sc];
        int[][] ans = image;
        int[] delRow = {-1,0,+1,0};
        int[] delCol = {0, +1, 0,-1};
        dfs(image, sr, sc, newColor, ans, delRow, delCol, initColor);
        return ans;
    }

    private static void dfs(int[][] image, int sr, int sc, int newColor, int[][] ans, int[] delRow, int[] delCol, int initColor) {
        ans[sr][sc]= newColor;
        int n= image.length;
        int m = image[0].length;
        for(int i=0;i<4;i++){
            int curRow=delRow[i]+sr;
            int curCol=delCol[i]+sc;
            if(curRow>=0 && curRow<n && curCol>=0 && curCol<m && image[curRow][curCol] == initColor && ans[curRow][curCol] !=newColor){
                dfs(image, curRow, curCol, newColor, ans, delRow, delCol, initColor);
            }

        }
    }

    public static void main(String[] s){

    }
}
