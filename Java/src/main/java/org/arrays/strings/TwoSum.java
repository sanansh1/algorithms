package org.arrays.strings;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // Map-
    // target -current number, ==0, map

    public static int[] twoSumHashMap(int[] a, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++){
            int x = target-a[i];
            if(map.containsKey(x)){
                return new int[]{i, map.get(x)};
            } else{
                map.put(a[i], i);
            }
        }
        return new int[]{-1,-1};
    }


    public static void main(String[] str){
        int[] res = twoSumHashMap(new int[]{5,8,0,3,6,8,1,9},9);
        for(int n:res){
            System.out.println("Result"+n);
        }
    }
}
