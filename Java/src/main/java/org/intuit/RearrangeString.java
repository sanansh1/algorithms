package org.intuit;

import java.util.Arrays;

public class RearrangeString {

    public static String rearrange(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        int n = arr.length;
        char[] result = new char[n];

        // Try to place the smallest available characters to the required positions
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                result[left++] = arr[i];
            } else {
                result[right--] = arr[i];
            }
        }

        // Verify the result to check if it satisfies the condition
        /*for (int i = 0; i < n / 2; i++) {
            if (result[i] == result[n - i - 1]) {
                return "Not possible";
            }
        }*/

        return new String(result);
    }

    public static void main(String[] args) {
        String[] testCases = {
                "aabb",
                "aaabbb",
                "abcabc",
                "aabbcc",
                "aaaa",
                "abab", "testking"
        };

        for (String s : testCases) {
            System.out.println("Original: " + s + " -> Rearranged: " + rearrange(s));
        }
    }
}
