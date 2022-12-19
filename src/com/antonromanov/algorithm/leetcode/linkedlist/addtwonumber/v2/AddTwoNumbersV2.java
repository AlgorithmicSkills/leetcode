package com.antonromanov.algorithms.linkedlist.addtwonumber.v2;

import com.antonromanov.algorithms.linkedlist.ListNode;

public class AddTwoNumbersV2 {

    public static ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode res = null;
        int store = 0;
        while (n1 != null || n2 != null || store >0) {
            int sum = (n1==null ? 0 : n1.val) + (n2==null? 0: n2.val) + store;
            store = 0;
            if (sum >= 10) {
                store = 1;
                sum = sum-10;
            }
            if (res == null) {
                res = new ListNode(sum);
            } else {
                ListNode currentNode = res;
                while(currentNode.next!= null){
                    currentNode = currentNode.next;
                }
                currentNode.next = new ListNode(sum);
            }

            n1 = (n1==null ? null : n1.next);
            n2 = (n2==null ? null : n2.next);
        }
        return res;
    }



    public static ListNode fillTestCase2() {
        ListNode l3 = new ListNode(3, null);
        ListNode l2 = new ListNode(4, l3);
        ListNode L1 = new ListNode(9, null);

        return L1;
    }

    public static ListNode fillTestCase3() {
        // [1,9,9,9,9,9,9,9,9,9]
        ListNode l11 = new ListNode(1, null);
        ListNode l10 = new ListNode(1, l11);
        ListNode l9 = new ListNode(1, l10);
        ListNode l8 = new ListNode(1, l9);
        ListNode l7 = new ListNode(1, l8);
        ListNode l6 = new ListNode(1, l7);
        ListNode l5 = new ListNode(1, l6);
        ListNode l4 = new ListNode(1, l5);
        ListNode l3 = new ListNode(1, l4);
        ListNode l2 = new ListNode(1, l3);
        ListNode L1 = new ListNode(1, l2);

        return L1;
    }
}
