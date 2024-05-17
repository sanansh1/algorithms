package org.bitmanipulation;

public class Swap2Numbers {
    public static int[] swap(int a, int b) {
        System.out.print(a + ": " + b + " ");
        b = (a ^ b);
        System.out.print(a + ": " + b + " ");

        a = (a ^ b);
        System.out.print(b + ": " + a + " ");
        b = (a ^ b);
        System.out.print(a + ": " + b + " ");
        return new int[]{a, b};
    }

    public static void main(String[] s) {
        int[] res = swap(10, 8);
        System.out.print(res[0] + ":" + res[1]);
    }
}
