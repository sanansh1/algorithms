package org.pramp;

// Binary search
public class RootOfNumber {

    public static double getRoot(double x, int n) {
        //
        double left = 0, right = x;
        double mid = (right + left) / 2;
        while (mid - left >= 0.001) {
            if (helper(mid, n) > x) {
                right = mid;
            } else if (helper(mid, n) < x) {
                left = mid;
            } else {
                return mid;
            }
            mid = left + (right - left) / 2;
        }
        return mid;
    }

    static double helper(double val, int n) {
        double ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= val;
        }
        return ans;
    }

    public static void main(String[] s) {
        System.out.println(getRoot(7, 3));
    }
}
