package org.pramp;

public class RegularExpression {

    public static boolean isMatch(String s, String p) {
        boolean[][] cache = new boolean[s.length() + 1][p.length() + 1];
        cache[s.length()][p.length()] = true;
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean match = i < s.length()
                        && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if ((j + 1) < p.length() && p.charAt(j + 1) == '*') {
                    cache[i][j] = cache[i][j + 2];
                    if (match) {
                        cache[i][j] = cache[i + 1][j] || cache[i][j];
                    }
                } else if (match) {
                    cache[i][j] = cache[i + 1][j + 1];
                }
            }
        }

        return cache[0][0];
    }

    public static void main(String[] s) {
        System.out.print(isMatch("aa", "a"));
    }
}
