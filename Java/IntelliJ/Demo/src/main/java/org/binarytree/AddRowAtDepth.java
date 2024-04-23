package org.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class AddRowAtDepth {
    public static TreeNode addRow(TreeNode root, int depth, int v) {
        Queue<Pair> queue = new LinkedList<>();
        TreeNode node = root;
        queue.add(new Pair(node, 1));
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.peek().node;
            int d = queue.peek().depth;
            if (d == depth - 1) {
                break;
            }
            for (int i = 0; i < queue.size(); i++) {
                TreeNode cur = queue.poll().node;
                if (cur.left != null) {
                    queue.add(new Pair(cur.left, d + 1));
                }
                if (cur.right != null) {
                    queue.add(new Pair(cur.right, d + 1));
                }
            }

        }
        if (!queue.isEmpty()) {
            TreeNode curNode = queue.peek().node;
            int d = queue.peek().depth;
            curNode.left = new TreeNode(v, curNode.left, null);
            curNode.right = new TreeNode(v, null, curNode.right);
        }
        return root;
    }

    public static void main(String[] s) {

    }

    static class Pair {
        TreeNode node;
        int depth;

        Pair(TreeNode node, int d) {
            this.node = node;
            this.depth = d;
        }
    }
}
