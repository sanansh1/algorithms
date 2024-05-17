package org.blind79;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {
    public static List<Integer> nextPerm(List<Integer> a) {
        int i = -1;
        for (int j = a.size() - 2; j >= 0; j--) {
            if (a.get(j) < a.get(j + 1)) {
                i = j;
                break;
            }
        }
        if (i == -1) {
            // reverse the whole array:
            Collections.reverse(a);
            return a;
        }
        for (int j = a.size() - 1; j >= 0; j--) {
            if (a.get(j) > a.get(i)) {
                int tmp = a.get(j);
                a.set(j, a.get(i));
                a.set(i, tmp);
                break;
            }
        }

        List<Integer> subList = a.subList(i + 1, a.size());
        Collections.reverse(subList);
        return a;

    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(2, 1, 5, 4, 3, 0, 0);
        List<Integer> ans = nextPerm(A);

        System.out.print("The next permutation is: [");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("]");

    }

}
