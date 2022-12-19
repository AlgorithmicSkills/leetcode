package com.antonromanov.algorithms.hashtable.twosums;

import java.util.HashMap;
import java.util.Map;

public class TwoSumsSolution {
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> table = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (table.containsKey(nums[i])) {
                res[0] = table.get(nums[i]);
                res[1] = i;
                return res;
            }
            table.put(target - nums[i], i);
        }

        return res;
    }
}
