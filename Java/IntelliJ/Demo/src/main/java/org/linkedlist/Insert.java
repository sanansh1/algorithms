package org.linkedlist;

public class Insert {
    public static ListNode insertHead(ListNode head, int k) {
        ListNode temp = new ListNode(k, head);
        return temp;
    }

    public static ListNode insertTail(ListNode head, int k) {
        if (head == null) {
            return new ListNode(k);
        }
        ListNode temp = head;
        while (temp.next != null)
            temp = temp.next;

        ListNode newNode = new ListNode(k);
        temp.next = newNode;
        return head;
    }

    public static ListNode insertKthPosition(ListNode head, int k) {
        int cnt = 0;
        if (head == null) {
            if (k == 1) {
                return new ListNode(k);
            } else {
                return head;
            }
        }
        if (k == 1) {
            return new ListNode(k, head);
        }

        ListNode temp = head;
        while (temp != null) {
            cnt++;
            if (cnt == k - 1) {
                ListNode newNode = new ListNode(k, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] s) {

    }
}
