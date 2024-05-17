package org.blind75;

/**
 * // Recursive function to find the maximum path sum
 * // for a given subtree rooted at 'root'
 * // The variable 'maxi' is a reference parameter
 * // updated to store the maximum path sum encountered
 */
public class MaxPathSumTree {
    public static int maxPathSum(TreeNode1 node) {
        int[] maxi = {Integer.MIN_VALUE};
        findMaxSum(node, maxi);
        return maxi[0];
    }

    public static int findMaxSum(TreeNode1 node, int[] maxi) {
        if (node == null) {
            return 0;
        }
        int lSum = Math.max(0, findMaxSum(node.left, maxi));
        int rSum = Math.max(0, findMaxSum(node.right, maxi));
        maxi[0] = Math.max(maxi[0], lSum + rSum + node.val);
        return Math.max(lSum, rSum) + node.val;
    }

    public static void main(String[] s) {
// Creating a sample binary tree
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(2);
        root.right = new TreeNode1(3);
        root.left.left = new TreeNode1(4);
        root.left.right = new TreeNode1(5);
        root.left.right.right = new TreeNode1(6);
        root.left.right.right.right = new TreeNode1(7);


        // Finding and printing the maximum path sum
        int maxPathSum = maxPathSum(root);
        System.out.println("Maximum Path Sum: " + maxPathSum);
    }
}
