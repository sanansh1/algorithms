package com.example;

public class TreeNode {
    int value;
    TreeNode leftChild;
    TreeNode rightChild;
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public TreeNode getLeftChild() {
        return leftChild;
    }
    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }
    public TreeNode getRightChild() {
        return rightChild;
    }
    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
    public TreeNode(int value, TreeNode leftChild, TreeNode rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    public TreeNode(int value) {
        this.value = value;
    }
    
}
