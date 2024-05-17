package org.linkedlist;

public class SearchElement {
    public static boolean searchElement(ListNode head, int k) {
        ListNode node = head;
        while (node != null) {
            if (node.val == k) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public static void main(String[] s) {

    }
}
