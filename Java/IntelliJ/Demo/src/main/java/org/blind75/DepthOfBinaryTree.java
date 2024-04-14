package org.blind75;

public class DepthOfBinaryTree {
    public static int maxDepth(TreeNode1 root) {
        if (root != null) {
            int lh = maxDepth(root.left);
            int rh = maxDepth(root.right);
            return 1 + Math.max(lh, rh);
        }
        return 0;
    }
}
