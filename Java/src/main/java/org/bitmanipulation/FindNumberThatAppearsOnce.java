package org.bitmanipulation;

import java.util.HashMap;
import java.util.Map;

public class FindNumberThatAppearsOnce {
    /*
    iterate over 2 loops to check count
     */
    public static int findNumberBrute(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            int num = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (num == arr[j]) {
                    count++;
                }
            }
            if (count == 1) {
                return num;
            }
        }
        return -1;
    }

    public static int findNumberBetter(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry element : map.entrySet()) {
            if ((int) element.getValue() == 1) {
                return (int) element.getKey();
            }
        }
        return -1;
    }

    public static int findNumberOptimal(int[] arr) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }
        return xor;
    }

    public static void main(String[] s) {

    }
}
