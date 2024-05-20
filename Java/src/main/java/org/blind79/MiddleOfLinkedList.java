package org.blind79;

public class MiddleOfLinkedList {
    public static ListNode mid(ListNode head) {
        ListNode temp = head;
        ListNode slow = temp;
        ListNode fast = temp;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        // Creating a sample linked list:
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        // Find the middle node
        ListNode middleNode = mid(head);

        // Display the value of the middle node
        System.out.println("The middle node value is: " + middleNode.val);
    }
}
