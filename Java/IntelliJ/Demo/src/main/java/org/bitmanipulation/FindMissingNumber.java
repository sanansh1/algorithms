package org.bitmanipulation;

import java.util.Arrays;

/*
Brute force - 2 for loops to check if value is present
Better - hashing O(2N), SC- O(N)
Optimal -
 */
public class FindMissingNumber {
    public static int findMissingBrute(int[] arr) {
        for (int i = 1; i <= arr.length; i++) {
            int flag = 0;
            for (int j = 0; j < arr.length; j++) {
                if (i == arr[j]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int findMissingBetter(int[] arr) {
        // create hash
        int[] hash = new int[arr.length + 1];
        Arrays.fill(hash, 0);
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]] = 1;
        }
        for (int i = 1; i <= arr.length; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    public static int findMissingOptimal(int[] arr) {
        int n = arr.length;
        int sum = (n * (n + 1)) / 2;
        int actualSum = 0;
        for (int i = 0; i < arr.length; i++) {
            actualSum = actualSum + arr[i];
        }
        return sum - actualSum;
    }

    public static void main(String s) {

    }
}
