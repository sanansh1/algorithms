package org.binarytree;

public class ValidBST {
    static Integer prev = null;
    public static boolean validBST(TreeNode root){
        return inorder(root);
    }

    public static boolean inorder(TreeNode node){
        if(node == null){
            return Boolean.TRUE;
        }
        if(!inorder(node.left)){
            return Boolean.FALSE;
        }
        if(prev!=null && prev>node.val){
            return Boolean.FALSE;
        }
        prev=node.val;
        return inorder(node.right);
    }

    public static void main(String[] s){

    }
}
