package org.linkedlist;

public class ConvertArrayToLinkedList {
    public static ListNode convertArrToLL(int[] a) {
        ListNode head = new ListNode(a[0]);
        ListNode move = head;
        for (int i = 1; i < a.length; i++) {
            ListNode temp = new ListNode(a[i]);
            move.next = temp;
            move = temp;
        }
        return head;
    }

    public static void main(String[] s) {
        ListNode head = convertArrToLL(new int[]{2, 7, 3, 6, 4, 10});
        ListNode move = head;
        while (move != null) {
            System.out.print(move.val + " ");
            move = move.next;
        }

    }
}
