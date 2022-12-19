package com.antonromanov.algorithms.linkedlist.reverse;

import com.antonromanov.algorithms.linkedlist.ListNode;

import java.util.Stack;

public class Reverse {

    private static int counter = 0;

    public static ListNode mySolution(ListNode head) {
        ListNode currNode = head;
        ListNode reverseList = new ListNode(head.val);
        ListNode l1 = null;
        while (currNode.next!=null){
            currNode = currNode.next;
            l1 = new ListNode(currNode.val, reverseList);
            reverseList = l1;
        }
        return l1;
    }

    public static ListNode reverseRecursive(ListNode head) {
        if(head==null || head.next==null)
            return head;
        counter+=1;
        ListNode nextNode=head.next;
        ListNode newHead=reverseRecursive(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;
    }

    public static ListNode usingStackSolution(ListNode head) {
        Stack<ListNode> st = new Stack();
        ListNode l = new ListNode(0);
        ListNode temp = l;
        while(head != null){
            st.push(head);
            head = head.next;
        }
        while(!st.isEmpty()){
            temp.next = st.pop();
            temp = temp.next;
        }
        temp.next = null;
        return l.next;
    }
}
