package org.blind75;

public class SymmetricalBinaryTree {
    public static boolean isSymmetric(TreeNode1 root) {
        if (root == null) {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }

    public static boolean isSymmetricHelper(TreeNode1 node1, TreeNode1 node2) {
        if (node1 == null || node2 == null) {
            return node1 == node2;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return isSymmetricHelper(node1.left, node2.right) && isSymmetricHelper(node1.right, node2.left);
    }

    public static void main(String[] s) {
        TreeNode1 root2 = new TreeNode1(1);
        root2.left = new TreeNode1(2);
        root2.right = new TreeNode1(3);
        root2.left.left = new TreeNode1(4);
        System.out.println(isSymmetric(root2));
    }
}
