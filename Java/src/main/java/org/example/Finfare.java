package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Finfare {

    /**
     * Case1:
     * Input1: collection[1,2,3,4,5,6,7,8,9]
     * Input2: Number of item per mini bag : 3
     * Output : [ [1,2,3],[4,5,6],[7,8,9] ]
     * <p>
     * Case2:
     * Input1: collection[1,2,3,4,5,6,7,8,9]
     * Input2: Number of item per mini bag : 4
     * Output : [ [1,2,3,4],[5,6,7,8],[9] ]
     */
    public static List<List<Integer>> getMinBags(List<Integer> input, int size) {
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;
        List<Integer> minList = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            if (count == size) {
                result.add(minList);
                count = 0;
                minList = new ArrayList<>();
            }
            minList.add(input.get(i));
            count += 1;
        }
        result.add(minList);
        return result;
    }

    public static void main(String[] s) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<List<Integer>> res = getMinBags(input, 4);
        System.out.println(res);
    }
}
