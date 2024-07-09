package org.backtracking;

import java.util.ArrayList;

public class CombinationSum {
    public static void backtrack(int[] arr, int index, int target, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> ds) {
        //System.out.println(target + ":target" + ds.size() + ":ds" + index + ":index" + arr[index] + ":arr[index]");
        //System.out.print("index:" + index + ":target:" + target + ": ");
        if (index == arr.length) {
            //System.out.print(":" + index + ":" + target + ": ");
            if (target == 0) {
                ans.add(new ArrayList<Integer>(ds));
            }
            return;
        }

        if (arr[index] <= target) {
            //System.out.printf(":" + arr[index] + ":arr[index]:");
            ds.add(arr[index]);
            backtrack(arr, index, target - arr[index], ans, ds);
            ds.remove(ds.size() - 1);
        }
        backtrack(arr, index + 1, target, ans, ds);
    }

    public static ArrayList<ArrayList<Integer>> combSum(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        backtrack(arr, 0, target, ans, new ArrayList());
        return ans;
    }

    public static void main(String[] s) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        ArrayList<ArrayList<Integer>> ans = combSum(arr, target);
        System.out.println(ans);
    }
}
