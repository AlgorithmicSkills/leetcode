package com.antonromanov.algorithms.linkedlist.merged;

import com.antonromanov.algorithms.linkedlist.ListNode;

public class MyRecursiveSolve {
    public static ListNode myMergeKLists(ListNode[] lists) {
        return myPartion(lists, 0, lists.length - 1);
    }

    private static ListNode myPartion(ListNode[] lists, int start, int end) {
        return null;
    }

    // [[1,4,5],[1,3,4],[2,6]]
    private static ListNode mergeIt(ListNode l1, ListNode l2) {
       /* if (l1.next == null) return l1;
        if (l2.next == null) return l2;

        if (l1.val>l2.val){
            return new ListNode(l1.val, l2);
        } else {
            return mergeIt()
        }
        return l1;*/


        /*ListNode res = null;
        if(l1.val<l2.val){
            res = new ListNode(l1.val, l2);
        } else{
            res = mergeIt(l2.next, l1);
        }
        return res;*/
        return null;


    }
}
