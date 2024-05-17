package org.pramp;

public class SpiralCopy {
    // TC -> O(M*N)
    public static int[] spiral(int[][] inputMatrix) {
        int m = inputMatrix.length;
        int n = inputMatrix[0].length;
        int[] ans = new int[m * n];
        int index = 0;
        int leftBound = 0, rightBound = n - 1;
        int upperBound = 0, lowerBound = m - 1;
        while (index < m * n) {
            // left-> right
            if (upperBound <= lowerBound) {
                for (int i = leftBound; i < rightBound; i++) {
                    ans[index++] = inputMatrix[upperBound][i];
                }
                upperBound++;
            }
            // right-> down
            if (leftBound <= rightBound) {
                for (int i = upperBound; i < lowerBound; i++) {
                    ans[index++] = inputMatrix[i][rightBound];
                }
                rightBound--;
            }
            // down->left
            if (upperBound <= lowerBound) {
                for (int i = rightBound; i > leftBound; i--) {
                    ans[index++] = inputMatrix[lowerBound][i];
                }
                lowerBound--;
            }
            //left->up
            if (leftBound <= rightBound) {
                for (int i = lowerBound; i > upperBound; i--) {
                    ans[index++] = inputMatrix[i][leftBound];
                }
                leftBound--;
            }
        }
        return ans;
    }

    public static void main(String[] s) {

    }
}
