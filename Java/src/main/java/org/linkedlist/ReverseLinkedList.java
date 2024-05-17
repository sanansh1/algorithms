package org.linkedlist;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head){
    ListNode current = head;
    ListNode currNext = null;
    ListNode currPrev = null;

    while(current !=null){
        currNext = current.next;
        current.next = currPrev;
        currPrev=current;
        current=currNext;
    }
    return currPrev;
    }
    public static void main(String[] s){

    }
}
