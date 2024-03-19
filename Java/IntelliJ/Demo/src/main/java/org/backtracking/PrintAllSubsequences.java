package org.backtracking;

import java.util.ArrayList;

public class PrintAllSubsequences {

    public static void backtrack(int index, ArrayList<Integer> res, int[] arr) {
        if (index >= arr.length) {
            for (int number : res) {
                System.out.print(number + " ");
            }
            System.out.print("\n ");
            return;
        }
        res.add(arr[index]);
        backtrack(index + 1, res, arr);
        res.remove(res.size() - 1);
        backtrack(index + 1, res, arr);
    }

    public static void getAllSubsequences(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        backtrack(0, res, arr);
    }

    public static void main(String[] s) {
        getAllSubsequences(new int[]{3, 1, 2});
    }
}
