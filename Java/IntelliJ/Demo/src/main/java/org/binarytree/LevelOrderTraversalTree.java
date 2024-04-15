package org.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalTree {
    public static List<List<Integer>> levelOrder(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode cNode = queue.peek();
            int level = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                if (cNode.left != null) {
                    queue.add(cNode.left);
                }
                if (cNode.right != null) {
                    queue.add(cNode.right);
                }
                levelList.add(queue.poll().val);
            }
            res.add(levelList);
        }
        return res;
    }

    public static void main(String[] s) {

    }
}
