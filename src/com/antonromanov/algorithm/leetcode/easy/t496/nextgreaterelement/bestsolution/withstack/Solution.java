package com.antonromanov.algorithm.leetcode.easy.t496.nextgreaterelement.bestsolution.withstack;

import java.util.*;

/**
 * Not my best 10 strings solution with Stack for debug and Understanding.
 *
 * url: <a href="https://leetcode.com/problems/next-greater-element-i/solutions/2703151/java-10-lines-linear-time-complexity-o-n/">...</a>
 */
public class Solution {
    public static int[] nextGreaterElementBestSolution(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }
}
