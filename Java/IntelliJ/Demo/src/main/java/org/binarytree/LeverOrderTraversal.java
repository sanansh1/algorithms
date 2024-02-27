package org.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LeverOrderTraversal {

    public static List<List<Integer>> levelOrderTraversal(TreeNode node){
        List<List<Integer>> levels =new ArrayList<List<Integer>>();
        if(node==null){
            return levels;
        }
        helper(levels, node, 0);
        return levels;
    }

    public static void helper(List<List<Integer>> levels, TreeNode node, int level){
        if(levels.size()==level){
            levels.add(new ArrayList<Integer>());
        }
        levels.get(level).add(node.val);
        if(node.left!=null){
            helper(levels, node.left,level+1);
        }
        if(node.right!=null){
            helper(levels,node.right,level+1);
        }


    }
    public static void main(String[] s){

    }
}
