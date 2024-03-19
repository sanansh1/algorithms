package org.backtracking;

import java.util.ArrayList;

public class SubsequenceWithSumK {
    public static void subsequenceWithSumK(int[] arr, int K) {
        ArrayList<Integer> result = new ArrayList<>();
        backtrack(0, arr, 0, result, K);
    }

    public static void backtrack(int index, int[] arr, int sum, ArrayList<Integer> res, int K) {

        if (index == arr.length) {
            if (sum == K) {
                for (int num : res) {
                    System.out.print(num + " ");
                }
                System.out.println("\n");
            }
            return;
        }
        res.add(arr[index]);
        sum += arr[index];
        backtrack(index + 1, arr, sum, res, K);
        res.remove(res.size() - 1);
        sum -= arr[index];
        backtrack(index + 1, arr, sum, res, K);
    }

    public static void main(String[] s) {
        subsequenceWithSumK(new int[]{1, 2, 1}, 2);
    }
}
