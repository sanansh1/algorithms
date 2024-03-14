package org.recursion;

public class PrintName {
    public static void printName(int n, int start) {
        if (start > n) {
            return;
        }
        System.out.println(start);
        //start+=1;
        printName(n, start + 1);
    }

    public static void main(String[] s) {
        printName(5, 1);
    }
}
