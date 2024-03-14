package org.arrays.strings;

public class IsPrime {
    public static boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            System.out.println(i);
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] s) {
        System.out.println(isPrime(8));
    }
}
