package org.arrays.strings;

public class SquareRootOfNumber {
    public static long squareRoot(int n) {
        if (n < 2) {
            return n;
        }
        long left = 2, right = n / 2;
        while (left < right) {
            long pivot = left + (right - left) / 2;
            long prod = pivot * pivot;
            if (prod < n) {
                left = pivot + 1;
            } else if (prod > n) {
                right = pivot - 1;
            } else {
                return pivot;
            }
        }
        return right;
    }

    public static void main(String[] s) {
        long n = squareRoot(16);
        System.out.println("Square root of a number - "+n);
    }
}
