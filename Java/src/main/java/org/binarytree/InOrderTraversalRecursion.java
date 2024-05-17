package org.binarytree;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversalRecursion {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    public static void helper(TreeNode root, List<Integer> res){
        if(root!=null){
            helper(root.left, res);
            res.add(root.val);
            helper(root.right,res);
        }
    }

    public static void main(String[] s){

    }
}
