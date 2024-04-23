package org.amazon;

import java.util.Arrays;
import java.util.Collections;

public class MinKeyPresses {

    public static int minimumKeypresses(String s) {
        Integer[] arr = new Integer[26];
        Arrays.fill(arr, 0);
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] += 1;
        }
        int result = 0;
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (i < 9) {
                result += arr[i];
            } else if (i < 18) {
                result += 2 * arr[i];
            } else {
                result += 3 * arr[i];
            }
        }
        return result;
    }

    public static void main(String[] s) {
        System.out.println(minimumKeypresses("fgdr4"));
    }
}
