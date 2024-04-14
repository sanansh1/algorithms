package org.twopointer;

// TC - O(N)
public class TrappingRainWater {
    static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0, res = 0;
        // two pointers
        while (left <= right) {
            // check the min height
            if (height[left] <= height[right]) {
                // compare with max left height
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    // update result of trapped water
                    res = res + maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    res = res + maxRight - height[right];
                }
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("max trap water is " + trap(arr));
    }
}
