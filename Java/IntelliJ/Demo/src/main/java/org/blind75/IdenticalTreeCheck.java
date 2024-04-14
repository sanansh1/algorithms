package org.blind75;

public class IdenticalTreeCheck {
    public static boolean isIdentical(TreeNode1 node1, TreeNode1 node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) return false;
        boolean l = isIdentical(node1.left, node2.left);
        boolean r = isIdentical(node1.right, node2.right);
        return l && r;
    }

    public static void main(String[] s) {
        TreeNode1 root1 = new TreeNode1(1);
        root1.left = new TreeNode1(2);
        root1.right = new TreeNode1(3);
        root1.left.left = new TreeNode1(4);

        // Node2
        TreeNode1 root2 = new TreeNode1(1);
        root2.left = new TreeNode1(2);
        root2.right = new TreeNode1(3);
        root2.left.left = new TreeNode1(4);
        System.out.println(isIdentical(root1, root2));

    }
}



