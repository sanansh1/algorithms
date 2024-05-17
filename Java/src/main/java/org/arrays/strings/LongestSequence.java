package org.arrays.strings;

import java.util.HashSet;

public class LongestSequence {

    public static int longestConsecutive(int[] nums) {
        if(nums == null || nums.length <= 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int longest =1;
        int count =1;
        for(int n:nums){
            if(!set.contains(n-1)){
                while(set.contains(n+1)){
                    count++;
                    n++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    public static void main(String[] args){
    int n = longestConsecutive(new int[]{100,4,200,1,3,2});
    System.out.println("Longest sequence length- "+n);
    }
}
