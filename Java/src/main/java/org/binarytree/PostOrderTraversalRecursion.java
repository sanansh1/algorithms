package org.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversalRecursion {

    public static List<Integer> postOrderTraversal(TreeNode node){
    List<Integer> result = new ArrayList<>();
    helper(result,node);
    return result;
    }

    private static void helper(List<Integer> result, TreeNode node) {
        if(node==null){
            return;
        }
        helper(result, node.left);
        helper(result, node.right);
        result.add(node.val);
    }

    public static void main(String[] s){

    }
}
