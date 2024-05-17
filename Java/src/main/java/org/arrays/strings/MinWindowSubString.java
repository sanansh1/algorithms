package org.arrays.strings;

import java.util.HashMap;

public class MinWindowSubString {
    public static String minWindowSubstring(String s, String pattern) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : pattern.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int matched = 0;
        int left = 0;
        int minLength = s.length() + 1;
        int subStr = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if (map.get(s.charAt(right)) == 0) matched++;
            }
            while (minLength > right - left + 1 && matched == map.size()) {
                if (minLength > right - left + 1) {
                    minLength = right - left + 1;
                    subStr = left;
                }
                char c = s.charAt(left++);
                if (map.containsKey(c)) {
                    if (map.get(c) == 0) matched--;
                    map.put(c, map.get(c) + 1);
                }
            }
        }
        return minLength > s.length() ? "" : s.substring(subStr, subStr + minLength);
    }

    public static String minWindowSubstringBrute(String s, String pattern) {
        return null;
    }

    public static void main(String[] s) {
        System.out.println("Min substring - " + minWindowSubstring("ADOBECODEBANC", "ABC"));
    }
}
