package org.blind75;

import java.util.LinkedList;
import java.util.Queue;

//TODO not complete
public class WidthOfBinaryTree {
    public static int widthOfTree(TreeNode1 node) {
        Queue<TreeNode1> queue = new LinkedList<>();
        queue.add(node);
        int width = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode1 curNode = queue.peek();
                queue.remove();
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }

            }

        }
        return width;
    }

    public static void main(String[] s) {

    }
}
