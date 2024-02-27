package org.binarytree;

public class MaxDepth {
    public static int maxDepth(TreeNode node){
        if (node == null){
            return 0;
        }
        int leftDepth= maxDepth(node.left);
        int rightDepth=maxDepth(node.right);
        return Math.max(leftDepth,rightDepth)+1;
    }

    public static void main(String[] n){

    }
}
