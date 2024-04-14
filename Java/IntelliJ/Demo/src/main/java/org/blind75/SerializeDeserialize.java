package org.blind75;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserialize {
    public static String serialize(TreeNode1 node) {
        if (node == null) {
            return "";
        }
        Queue<TreeNode1> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode1 curNode = queue.peek();
            if (curNode == null) {
                sb.append("n ");
                continue;
            }
            sb.append(node.val + " ");
            queue.poll();
            queue.add(curNode.left);
            queue.add(curNode.right);
        }
        return sb.toString();
    }

    public static TreeNode1 deSerialize(String s) {
        if (s == null) {
            return null;
        }
        String[] values = s.split(" ");
        TreeNode1 root = new TreeNode1(Integer.parseInt(values[0]));
        Queue<TreeNode1> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 0; i < values.length; i++) {
            TreeNode1 parent = queue.poll();
            if (!values[i].equals("n")) {
                TreeNode1 left = new TreeNode1(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode1 right = new TreeNode1(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}
