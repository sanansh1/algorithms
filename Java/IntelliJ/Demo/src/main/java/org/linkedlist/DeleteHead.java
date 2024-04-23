package org.linkedlist;

public class DeleteHead {
    public static ListNode deleteHead(ListNode head) {
        if (head == null) {
            return head;
        }
        head = head.next;
        return head;
    }

    public static ListNode deleteTail(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return null;
        }
        ListNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static ListNode deleteKthNode(ListNode head, int k) {
        int c = 0;
        if (head == null) {
            return head;
        }
        if (k == 1) {
            head = head.next;
            return head;
        }

        ListNode temp = head, prev = null;
        while (temp != null) {
            c++;
            if (c == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }


    public static void main(String[] s) {

    }
}
