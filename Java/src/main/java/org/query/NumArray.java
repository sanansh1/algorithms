package org.query;

public class NumArray {
    int[] nums;

    public NumArray(int[] num) {
        nums = new int[num.length];
        System.arraycopy(num, 0, nums, 0, num.length);
    }

    public static void main(String[] s) {
        
    }

    int sumRange(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum = sum + nums[k];
        }
        return sum;
    }
}