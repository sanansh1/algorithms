package org.array;

public class PascalTriangle {


    public static void main(String[] args) {
        // pascal triangle at nth row
        int n = 5;
        pascalTriangle(n);
    }

    private static void pascalTriangle(int n) {
        int ans =1;

        for(int i=1;i<n;i++){
            ans = ans*(n-i);
            ans = ans/i;
            System.out.print(ans + " ");
        }
        System.out.println();
    }
}
