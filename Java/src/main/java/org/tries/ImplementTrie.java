package org.tries;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie {
    Node root = null;

    public ImplementTrie() {
        root = new Node();
        root.ch = null;
    }

    public static void main(String[] s) {

    }

    public void insert(String word) {
        Node node = root;
        System.out.println(word);
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            System.out.print(c + " ");
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
                node.isEndOfWord = node.isEndOfWord || word.length() - 1 == i;
            } else {
                Node newNode = new Node();
                newNode.ch = c;
                newNode.isEndOfWord = word.length() - 1 == i;
                newNode.children.put(c, newNode);
                node = newNode;
            }
        }
    }

    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (node.children.containsKey(c)) {
                System.out.print(c + " ");
                node = node.children.get(c);
                if (word.length() - 1 == i) {
                    return node.isEndOfWord;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
                if (prefix.length() - 1 == i) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    class Node {
        Map<Character, Node> children;
        Character ch;
        boolean isEndOfWord = false;

        Node() {
            children = new HashMap<>();
        }
    }
}
