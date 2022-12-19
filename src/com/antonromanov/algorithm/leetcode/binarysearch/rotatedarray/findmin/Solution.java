package com.antonromanov.algorithms.binarysearch.rotatedarray.findmin;


public class Solution {
    public static int searchInRotatedArray(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return (nums[left] < nums[right]) ? nums[left] : nums[right];
        }


        while (left + 1 < right) {

            int mid = (left + right) / 2; // середина
            if (nums[left] < nums[right]) { // если массив полностью отсортирован
                return nums[left];
            } else { // массив не отсортирован
                if (nums[left] < nums[mid]) {
                    nums[mid] = nums[left];
                    left = mid;
                } else {
                    left = left + 1;
                    if (left + 1 == right) {
                        return nums[left];
                    }
                }
            }
        }
        return (nums[left] < nums[right]) ? nums[left] : nums[right];
    }
}
