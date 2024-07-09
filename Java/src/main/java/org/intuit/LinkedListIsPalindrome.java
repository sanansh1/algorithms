package org.intuit;

import org.linkedlist.ListNode;

public class LinkedListIsPalindrome {
    public static boolean isPalindrome(ListNode head) {
        ListNode node = head;
        ListNode slow = node;
        ListNode fast = node;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        ListNode second = reverse(slow);
        while (node != null && second != null) {
            if (node.val != second.val) {
                return false;
            }
            node = node.next;
            second = second.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode nexttemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nexttemp;
        }
        return prev;
    }

    public static void main(String[] s) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        boolean result = isPalindrome(head);
        System.out.println("Is palindrome: " + result); // Output: true
    }
}

