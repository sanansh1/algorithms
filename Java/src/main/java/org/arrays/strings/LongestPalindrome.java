package org.arrays.strings;

public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if (s == null) {
            return null;
        } else if (s.length() <= 1) {
            return s;
        }
        String longPal = "";
        for (int i = 1; i < s.length(); i++) {

            //odd length
            int low = i, high = i;
            while (s.charAt(low) == s.charAt(high)) {
                low -= 1;
                high += 1;
                if (low == -1 || high == s.length()) {
                    break;
                }
            }
            String currPal = s.substring(low + 1, high);
            if (currPal.length() > longPal.length()) {
                longPal = currPal;
            }
            //even length
            low = i - 1;
            high = i;
            while (s.charAt(low) == s.charAt(high)) {
                low -= 1;
                high += 1;
                if (low == -1 || high == s.length()) {
                    break;
                }
            }
            currPal = s.substring(low + 1, high);
            if (currPal.length() > longPal.length()) {
                longPal = currPal;
            }
        }
        return longPal;
    }


    public static void main(String[] s) {
        String s1 = longestPalindrome("babad");
        System.out.println(s1);
    }
}
