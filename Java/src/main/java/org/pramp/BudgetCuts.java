package org.pramp;

import java.util.Arrays;

// can be done using binary search
public class BudgetCuts {

    public static double findGrantsCap(double[] a, double newBudget) {
        double cap = 0, avg = 0;
        int sum = 0, count = a.length - 1;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        avg = sum / (a.length - 1);
        if (sum == newBudget) {
            return avg;
        }
        double tempBudget = newBudget, tempCap = 0;
        //{2, 100, 50, 120, 167}
        Arrays.sort(a);
       /* for (int i = 0; i < a.length; i++) {
            if (a[i] < newBudget) {
                tempBudget = newBudget - a[i];
                if (tempBudget / (count - (i + 1)) == newBudget) {
                    return tempBudget / (count - (i + 1));
                }
                newBudget = tempBudget;
            }
        }*/
        //tempBudget -= a[0];
        cap = tempBudget / (count);
        for (int i = 0; i < count; i++) {
            System.out.println(cap);
            if ((int) cap > a[i]) {
                tempBudget -= a[i];
                cap = tempBudget / (count - i);
            }
        }

        return cap;
    }

    public static void main(String[] args) {
        double[] grantsArray = {2, 100, 50, 120, 1000};
        double newBudget = 190;

        System.out.println(findGrantsCap(grantsArray, newBudget));
    }
}
