package com.antonromanov.algorithms.binarysearch;

import java.util.Arrays;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        return recursiveBinarySearch(nums, target, 0);
    }

    private static int recursiveBinarySearch(int[] nums, int target, int pos) {
        if (nums.length<1) return -1;
        if (nums.length < 2) {
            if (nums[0] == target) {
                return pos;
            } else {
                return -1;
            }
        }
        int s = (nums.length) / 2;
        if (nums[s] == target) {
            return s+pos;
        } else if (nums[s] < target) {
            int[] newArr = Arrays.copyOfRange(nums, s+1, nums.length);
            return recursiveBinarySearch(newArr, target, pos+s+1);
        } else {
            int[] newArr = Arrays.copyOfRange(nums, 0, s);
            return recursiveBinarySearch(newArr, target, pos);
        }
    }
}
