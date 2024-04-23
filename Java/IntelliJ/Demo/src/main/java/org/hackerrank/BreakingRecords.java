package org.hackerrank;

import java.util.Arrays;
import java.util.List;

public class BreakingRecords {
    public static int[] breakingRecords(List<Integer> records) {
        int min = records.get(0), max = records.get(0), maxCount = 0, minCount = 0;
        for (int i = 1; i < records.size(); i++) {
            if (records.get(i) > max) {
                maxCount++;
                max = records.get(i);
            }
            if (records.get(i) < min) {
                min = records.get(i);
                minCount++;
            }
        }
        return new int[]{maxCount, minCount};
    }

    public static void main(String[] s) {
        int[] res = breakingRecords(Arrays.asList(10, 5, 20, 20, 4, 5, 2, 25, 1));
        for (int n : res)
            System.out.print(n + " ");
    }
}
