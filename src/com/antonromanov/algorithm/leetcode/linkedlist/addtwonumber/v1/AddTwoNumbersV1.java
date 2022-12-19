package com.antonromanov.algorithms.linkedlist.addtwonumber.v1;

import com.antonromanov.algorithms.linkedlist.ListNode;

public class AddTwoNumbersV1 {

    public static Long addTwoNumbers(ListNode l1, ListNode l2) {
        return toDigits(l1) + toDigits(l2);
    }

    public static long toDigits(ListNode l1) {
        long finNumber = 0L;
        int stepen = 0;
        while (l1 != null) {
            finNumber = finNumber + ((long) l1.val * pow(10, stepen));
            stepen = stepen+1;
            l1 = l1.next;
        }

       return finNumber;
    }

    public static ListNode toNode(Long i) {
        String finNumber = Long.toString(i);

        ListNode first = new ListNode(Integer.parseInt(finNumber.substring(finNumber.length()-1)));
        ListNode currentNode = first;
        for (int j = finNumber.length()-2; j >= 0; j--) {
            String tempS = finNumber.substring(j, j+1);
            ListNode l1 = new ListNode((Integer.parseInt(tempS)));
            currentNode.next = l1;
            currentNode = currentNode.next;
        }
        return first;
    }

    public static long pow(int value, int powValue) {
        long result = 1;
        for (int i = 1; i <= powValue; i++) {
            result = result * value;
        }
        return result;
    }

    public static ListNode fillTestCase2(){
        ListNode l7 = new ListNode(9,null);
        ListNode l6 = new ListNode(9,l7);
        ListNode l5 = new ListNode(9,l6);
        ListNode l4 = new ListNode(9,l5);
        ListNode l3 = new ListNode(9,l4);
        ListNode l2 = new ListNode(9, l3);
        ListNode L1 = new ListNode(9, l2);

        return L1;
    }

    public static ListNode fillTestCase21(){
        ListNode l4 = new ListNode(9,null);
        ListNode l3 = new ListNode(9,l4);
        ListNode l2 = new ListNode(9, l3);
        ListNode L1 = new ListNode(9, l2);

        return L1;
    }

    public static ListNode fillTestCase3(){
       // [1,9,9,9,9,9,9,9,9,9]
        ListNode l11 = new ListNode(1,null);
        ListNode l10 = new ListNode(1,l11);
        ListNode l9 = new ListNode(1,l10);
        ListNode l8 = new ListNode(1,l9);
        ListNode l7 = new ListNode(1,l8);
        ListNode l6 = new ListNode(1,l7);
        ListNode l5 = new ListNode(1,l6);
        ListNode l4 = new ListNode(1,l5);
        ListNode l3 = new ListNode(1,l4);
        ListNode l2 = new ListNode(1, l3);
        ListNode L1 = new ListNode(1, l2);

        return L1;
    }
}
