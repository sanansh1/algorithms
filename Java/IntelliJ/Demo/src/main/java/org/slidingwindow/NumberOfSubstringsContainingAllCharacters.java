package org.slidingwindow;

import java.util.Arrays;

public class NumberOfSubstringsContainingAllCharacters {
    public static int countOfSubstrings(char[] s) {
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            int[] hash = new int[3];
            Arrays.fill(hash, -1);
            for (int j = i; j < s.length; j++) {
                hash[s[j] - 'a'] = 1;
                //System.out.println(hash[s[j] - 'a']);
                if (hash[0] + hash[1] + hash[2] == 3) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countOfSubstringsSlidingWindow(char[] s) {
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            int[] hash = new int[3];
            Arrays.fill(hash, -1);
            for (int j = i; j < s.length; j++) {
                hash[s[j] - 'a'] = 1;
                //System.out.println(hash[s[j] - 'a']);
                if (hash[0] + hash[1] + hash[2] == 3) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] s) {
        System.out.println(countOfSubstrings(new char[]{'a', 'b', 'b', 'c', 'c'}));
    }
}
