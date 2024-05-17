package org.array;

/*
Brute force - Sort the array, then check if current index and previous index arr value TC - O(NlogN)
Better - HashMap - TC -O(N), SC - O(N)
Optimal - Linked list fast and slow pointer O(N), SC-O(1)
 */
public class FindDuplicateInArray {
    public static void main(String[] s) {
        System.out.println(findDuplicate(new int[]{2, 5, 7, 9, 3, 5, 6, 2}));
    }

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
