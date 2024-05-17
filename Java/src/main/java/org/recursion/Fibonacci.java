package org.recursion;

public class Fibonacci {

    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        int res = fibo(n - 1) + fibo(n - 2);
        System.out.println(res);
        return res;
    }

    public static void main(String[] s) {
        System.out.println(fibo(6));
    }
}
