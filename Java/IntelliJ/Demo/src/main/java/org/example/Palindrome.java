package org.example;

public class Palindrome {

    public static Boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return Boolean.FALSE;
        }
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            // char at left if alpha numeric and char at right alpha numeric, are they same
            if (!isAlphaNumeric(s.charAt(left))) {
                left += 1;
                continue;
            }
            if (!isAlphaNumeric(s.charAt(right))) {
                right -= 1;
                continue;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return Boolean.FALSE;
            }
            left += 1;
            right -= 1;
        }
        return Boolean.TRUE;
    }

    public static Boolean isAlphaNumeric(char c) {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        Boolean palindrome = isPalindrome(s);
        System.out.println(" palindrome - " + s + ":" + palindrome);
    }
}
