package org.recursion;

public class ReverseString {

    public static void reverse(String s) {
        helper(0, s);
    }

    public static void helper(int index, String s) {
        if (index >= s.length() || s == null) {
            return;
        }
        helper(index + 1, s);
        System.out.println(s.charAt(index));
    }

    public static char[] recursion(int i, char[] c) {
        if (i >= c.length / 2) {
            return c;
        }
        char temp = c[i];
        c[i] = c[c.length - i - 1];
        c[c.length - i - 1] = temp;
        return recursion(i + 1, c);
    }

    public static void reverseString(String s) {
        // convert it to array
        // call recursion 0
        // within recursion if i >=n/2 then return
        // swap i, n-i-1
        char[] tempArray = s.toCharArray();
        char[] res = recursion(0, tempArray);
        //System.out.println(res.toString());
        for (char c : res) {
            System.out.println(c);
        }

    }

    public static void main(String[] s) {
        //reverse("hello world");
        reverseString("hello world");
    }
}
