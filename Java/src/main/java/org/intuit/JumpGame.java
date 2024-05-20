package org.intuit;

public class JumpGame {
    public static int minJump(int[] arr) {
        int ans = 0, l = 0, r = 0;
        while (r < arr.length - 1) {
            int farthest = 0;
            for (int i = l; i < r + 1; i++) {
                farthest = Math.max(farthest, i + arr[i]);
            }
            l = r + 1;
            r = farthest;
            ans += 1;
        }
        return ans;
    }

    public static void main(String[] s) {
        int ans = minJump(new int[]{2, 3, 0, 1, 4});
        System.out.println(ans);
    }
}
