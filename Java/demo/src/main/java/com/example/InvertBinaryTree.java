package com.example;

import com.example.TreeNode;

public class InvertBinaryTree {

    public static TreeNode invertBinaryTree(TreeNode node) {
        if (node == null) {
            return null;
        }        
        TreeNode right = invertBinaryTree(node.rightChild);
        TreeNode left = invertBinaryTree(node.leftChild);
        node.leftChild = right;
        node.rightChild = left;
        return node;
    }

    public static void print(TreeNode node){
        if(node == null){
            return;
        }
        System.out.println(node.value);
        print(node.leftChild);
        print(node.rightChild);
    }

    public static void main(String[] args) {
        TreeNode leaf1 = new TreeNode(1);
        TreeNode leaf2 = new TreeNode(3);
        TreeNode leaf3 = new TreeNode(6);
        TreeNode leaf4 = new TreeNode(9);

        TreeNode nodeRight = new TreeNode(7, leaf3, leaf4);
        TreeNode nodeLeft = new TreeNode(2, leaf1, leaf2);

        TreeNode root = new TreeNode(4, nodeLeft, nodeRight);
        print(root);
        System.out.println("Inverting binary tree");
        TreeNode n = invertBinaryTree(root);
        print(n);

        
    }
}
