package org.recursion;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] a) {
        int pivot = a.length / 2;
        int[] leftArray = mergeSort(Arrays.copyOfRange(a, 0, pivot));
        int[] rightArray = mergeSort(Arrays.copyOfRange(a, pivot, a.length));
        return mergeRecur(leftArray, rightArray);
    }

    public static int[] mergeRecur(int[] a1, int[] a2) {
        int[] res = new int[a1.length + a2.length];
        int l = 0, r = 0, t = 0;
        while (l < a1.length && r < a2.length) {
            if (a1[l] < a2[r]) {
                res[t] = a1[l];
                l += 1;
                t += 1;
            } else {
                res[t] = a2[r];
                r += 1;
                t += 1;
            }
        }
        while (l < a1.length) {
            res[t] = a1[l];
            l += 1;
            t += 1;
        }
        while (r < a2.length) {
            res[t] = a2[r];
            r += 1;
            t += 1;
        }
        return res;
    }

    public static void main(String[] s) {

    }
}
