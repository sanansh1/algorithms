package org.recursion;

public class Permutation {
    public static void permutation(String s) {
        perm(s, "");
    }

    private static void perm(String s, String prefix) {
        if (s.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < s.length(); i++) {
                String rem = s.substring(0, i) + s.substring(i + 1);
                perm(rem, prefix + s.charAt(i));
            }
        }
    }

    public static void main(String[] s) {
        permutation("very");
    }
}
