package org.stacks;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValidParenthesis(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.pop();
                    if (((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '['))) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] s) {
        System.out.println(isValidParenthesis("{}{[]"));
    }
}
