package com.antonromanov.algorithms.linkedlist.findmiddle;

import com.antonromanov.algorithms.linkedlist.ListNode;

public class FindMiddle {
    public static ListNode middleNode(ListNode head) {

        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (slowPointer.next != null && fastPointer.next != null) {
            //   while (fastPointer.next.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            if (fastPointer == null){
                break;
            }

        }


        return slowPointer;
    }

    public static ListNode fillTestCase() {
        // [1,2,3,4,5]
        /*ListNode l11 = new ListNode(5, null);
        ListNode l10 = new ListNode(4, l11);
        ListNode l9 = new ListNode(1, l10);
        ListNode l8 = new ListNode(1, l9);
        ListNode l7 = new ListNode(1, l8);*/
        ListNode l6 = new ListNode(6, null);
        ListNode l5 = new ListNode(5, l6);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode L1 = new ListNode(1, l2);

        return L1;
    }
}
