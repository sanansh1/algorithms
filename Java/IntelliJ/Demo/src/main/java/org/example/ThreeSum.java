package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        // sort
        // compare current are next not same
        // for loop
        // while left pointer right pointer
        // if target is equal increment
        // if less, increment left, else decrement right
        Arrays.sort(nums);
        LinkedList<List<Integer>> linkedList = new LinkedList<>();
        if (nums.length == 0) {
            return linkedList;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int target = nums[i] + nums[left] + nums[right];
                    if (target == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        linkedList.add(list);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left += 1;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right -= 1;
                        }
                        left += 1;
                        right -= 1;
                    } else if (target < 0) {
                        left += 1;
                    } else {
                        right -= 1;
                    }
                }

            }
        }
        return linkedList;
    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        List<List<Integer>> list = threeSum(new int[]{-1, 0, 1, 2, -1, -4});

        for (List<Integer> integers : list) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + integers);
        }
    }
}