package org.stacks;

public class StackUsingArray {
    static int size, top;
    static int[] stack = new int[size];

    StackUsingArray(int size) {
        StackUsingArray.size = size;
        top = -1;
    }

    public static void push(int val) {

        stack[++top] = val;
    }

    public static int pop() {
        int val = stack[top];

        top--;
        return val;
    }

    public static int peek() {
        int val = stack[top];
        return val;
    }

    public static void main(String[] s) {

    }
}
