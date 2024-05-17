package org.backtracking;

import java.util.ArrayList;

public class CombinationSum {
    public static void backtrack(int[] arr, int index, int target, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> ds) {
        //System.out.println(target + ":target" + ds.size() + ":ds" + index + ":index" + arr[index] + ":arr[index]");
        //System.out.print("index:" + index + ":target:" + target + ": ");
        if (index == arr.length) {
            //System.out.print(":" + index + ":" + target + ": ");
            if (target == 0) {
                //System.out.println("ds:" + ds.size());
                //ans.add(new ArrayList<Integer>());
                ans.add(ds);
                ds = new ArrayList<Integer>();
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
        //ystem.out.println(ans.);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
