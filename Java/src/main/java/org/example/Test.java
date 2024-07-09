package org.example;

public class Test {
    /***
     *
     *
     * Common Words: Find the most common word in the sentences.
     * Design a function that can process a large dataset of text reviews and identify the most common words used in the reviews.
     * Return 10 most used words in the reviews, sort the words based on their counts in descending order, in case of ties,
     * words are sorted alphabetically.
     * The dataset is in csv format and includes the following fields: review_id, review_text.
     * Start by assuming the large dataset can fit in memory. If there is time, talk about how the
     * solution would change if the large dataset would not fit in memory.
     *
     * Input:
     * review_id, review_text
     * 1, This product is amazing!
     * 2, I hate this product
     *
     * Output: [‘product’, ‘this’, ‘amazing’, ‘hate’, ‘I’, ‘is]
     *
     * select id from table_name order by id desc limit 1;
     *
     */


    public static int getMidElement(Node head, int S) {
        int count = 0, mid = (S / 2) + 1;
        Node node = head;
        while (node != null) {
            count++;
            if (count == mid) {
                return node.val;
            }
            node = node.next;
        }
        return -1;
    }

    public static void main(String[] s) {
        // 5 6 1 14 6 10 3
        Node node = new Node(5);
        node.next = new Node(6);
        node.next.next = new Node(1);
        node.next.next.next = new Node(14);
        node.next.next.next.next = new Node(6);
        node.next.next.next.next.next = new Node(10);
        node.next.next.next.next.next.next = new Node(3);
        System.out.print(getMidElement(node, 7));

    }

    /**
     * Middle Element: Write a function to return the middle element from a one-way linked list.
     * Example Input: 5 6 1 14 6 10 3
     * Expected Output: 14
     */
    static class Node {
        int val;
        Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        Node(int val) {
            this.val = val;
        }
    }
}
