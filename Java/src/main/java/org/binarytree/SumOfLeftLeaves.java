package org.binarytree;

import java.util.Stack;

public class SumOfLeftLeaves {
    public static int leftLeavesSum(TreeNode root) {
        int total = 0;
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return 0;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (isLeaf(node.left)) {
                total += node.left.val;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return total;
    }

    public static boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    public static void main(String[] s) {

    }
}
