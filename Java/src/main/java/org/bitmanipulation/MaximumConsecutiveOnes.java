package org.bitmanipulation;

public class MaximumConsecutiveOnes {
    public static void main(String[] s) {

    }

    public static int maxConsecutiveOnes(int[] arr) {
        int maxCount = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }
}
