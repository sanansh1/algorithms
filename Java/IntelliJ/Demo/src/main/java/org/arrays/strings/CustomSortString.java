package org.arrays.strings;

public class CustomSortString {
    public static String customSortString(String order, String s) {
        if (s == null) {
            return null;
        }
        int left = 0, right = 0;
        StringBuilder b = new StringBuilder();
        while (left < order.length()) {
            if (s.contains(order.substring(left, left + 1))) {
                b.append(order.charAt(left));
            }
            left++;
        }
        String b1 = b.toString();
        while (right < s.length()) {
            if (!b1.contains(s.substring(right, right + 1))) {
                b.append(s.charAt(right));
            }
            right++;
        }
        return b.toString();
    }
}
