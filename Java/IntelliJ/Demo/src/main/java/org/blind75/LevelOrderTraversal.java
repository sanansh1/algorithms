package org.blind75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static List<List<Integer>> levelOrderTraversal(TreeNode1 node) {
        List<List<Integer>> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        Queue<TreeNode1> queue = new LinkedList<>();
        queue.add(node);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            List<Integer> levelOrders = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode1 curNode = queue.peek();
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
                levelOrders.add(queue.peek().val);
                queue.poll();
            }
            res.add(levelOrders);

        }
        return res;
    }

    public static void main(String[] s) {
// Creating a sample binary tree
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(2);
        root.right = new TreeNode1(3);
        root.left.left = new TreeNode1(4);
        root.left.right = new TreeNode1(5);


        // Perform level-order traversal
        List<List<Integer>> result = levelOrderTraversal(root);

        System.out.println("Level Order Traversal of Tree:");
        for (List<Integer> list : result) {
            for (int a : list) {
                System.out.print(a + " ");
            }
        }
    }
}
