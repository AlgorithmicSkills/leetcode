package com.antonromanov.algorithm.leetcode.easy.t1672.reachestcustomer;

import java.util.Arrays;

public class Solution {
    public static int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts)
               // .map(int[]::clone)
                .map(a->Arrays.stream(a).boxed().reduce(Integer::sum).get())
                .max(Integer::compareTo)
                .get();
    }
}
