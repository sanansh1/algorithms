package org.binarytree;

public class InvertTree {

    public static TreeNode invertTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode(node.val);
        newRoot.left = invertTree(node.right);
        newRoot.right = invertTree(node.left);
        return newRoot;
    }

    public static void main(String[] s) {

    }

}
