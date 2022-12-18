package com.antonromanov.algorithm.leetcode.easy.t496.nextgreaterelement.mysolution.withoutstack;

import java.util.*;

public class Solution {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        LinkedHashMap<Integer, LinkedList<Integer>> map = new LinkedHashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums2.length; i++) {
            if (i < nums2.length - 1) {
                map.put(nums2[i], getStack(nums2, i));
            } else {
                map.put(nums2[i], getStack(nums2, -1));
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            int curNum = nums1[i];

            try {
                LinkedList<Integer> r = map.entrySet().stream()
                        .filter(v -> v.getKey() == curNum )
                        .findFirst().map(Map.Entry::getValue).get();

                if (r.stream().filter(v->v>curNum).count()>0) {
                    res.add(r.stream().filter(v -> v > curNum).findFirst().get());
                } else {
                    res.add(-1);
                }

            } catch (Exception e) {
                res.add(-1);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static LinkedList<Integer> getStack(int[] nums2, int i) {
       // Stack<Integer> stk = new Stack<>();
        LinkedList<Integer> ls = new LinkedList<>();
        if (i == -1) {
           // stk.push(-1);
            ls.add(-1);
        } else {
            for (int j = i + 1; j < nums2.length; j++) {
              //  stk.push(nums2[j]);
                ls.add(nums2[j]);
            }
        }
        return ls;
    }

}
