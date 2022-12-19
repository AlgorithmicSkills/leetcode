package com.antonromanov.algorithms.linkedlist;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedListSolver {
    public static ListNode mergeKLists(ListNode[] lists){
        return partion(lists,0,lists.length-1);
    }


    public static boolean hasCycle(ListNode head) {
        if (head == null ){
            return false;
        }
        Set<ListNode> s = new HashSet<>();

        while (head!=null){


            if (s.contains(head.next)){
                return true;
            }

            s.add(head);
            head = head.next;
        }
        return false;
    }

    public static ListNode fillTestCase(){

        ListNode l4 = new ListNode(-4);
        ListNode l3 = new ListNode(0,l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode L1 = new ListNode(3, l2);

        l4.next = l2;

        return L1;
    }

    public static ListNode[] fillLists(){



      // [[1,4,5],[1,3,4],[2,6]]

        ListNode l3_2 = new ListNode(6);
        ListNode L3_1 = new ListNode(2, l3_2);

        ListNode l2_3 = new ListNode(4);
        ListNode l2_2 = new ListNode(3, l2_3);
        ListNode L2_1 = new ListNode(1, l2_2);

        ListNode l1_3 = new ListNode(5);
        ListNode l1_2 = new ListNode(4, l1_3);
        ListNode L1_1 = new ListNode(1, l1_2);

        List<ListNode> tempList = Arrays.asList(L1_1, L2_1, L3_1);
        return tempList.toArray(new ListNode[0]);
    }


    public static ListNode partion(ListNode[] lists,int s,int e){
        if(s==e)  return lists[s];
        if(s<e){
            int q=(s+e)/2;
            ListNode l1=partion(lists,s,q);
            ListNode l2=partion(lists,q+1,e);
            return merge(l1, l2);
        }else
            return null;
    }

    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }

}
