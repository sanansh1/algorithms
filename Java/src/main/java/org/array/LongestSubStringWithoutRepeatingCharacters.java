package org.array;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters {
    public static String longestSubString(String s) {
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int l = 0, r = 0;
        while (r < s.length()) {
            if (set.contains(s.charAt(r))) {
                while (l < r && set.contains(s.charAt(r))) {
                    set.remove(s.charAt(l));
                    l++;
                }
            } else {
                set.add(s.charAt(r));
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return "";
    }

    public static void main(String[] s) {

    }
}
