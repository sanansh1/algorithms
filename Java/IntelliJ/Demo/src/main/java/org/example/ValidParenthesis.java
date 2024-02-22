package org.example;

import java.util.Map;
import java.util.Stack;

import static java.util.Map.entry;

public class ValidParenthesis {
    public static Boolean validParenthesis(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = Map.ofEntries(entry('}', '{'),
                entry(')', '('), entry(']', '['));
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (!stack.isEmpty() && map.get(c).equals(stack.peek())) {
                    stack.pop();
                } else {
                    return Boolean.FALSE;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] s) {
        Boolean valid = validParenthesis("()([]){}");
        System.out.println("Is Valid Parenthesis - " + valid);
    }
}
