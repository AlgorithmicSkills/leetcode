package com.antonromanov.algorithms.binarysearch.rotatedarray.findtarget.v1;


public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if(nums.length==1){
            return nums[0]==target ? 0 : -1;
        }

        if (nums[left]==target){
            return left;
        }
        if (nums[right]==target){
            return right;
        }

        while (left+1 < right) {

            int mid = (left + right) / 2; // середина

            if (nums[left]==target){
                return left;
            }

            if (nums[right]==target){
                return right;
            }

            if (nums[mid]==target){
                return mid;
            }


            if (nums[left] < nums[right]) { // если массив полностью отсортирован

                if (target<nums[left] || target>nums[right]){
                    return -1;
                }
                if (target < nums[mid]) {
                    right=mid;
                } else if (target > nums[mid]) {
                    left=mid;
                } else {
                    return mid;
                }
            }  else { // массив не отсортирован
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[left] < nums[mid]) {
                    if (nums[left]<target && target<nums[mid]){
                        right = mid;
                    } else{
                        left = mid;
                    }
                } else {
                    if (nums[mid]<target && target<nums[right]){
                        left=mid;
                    } else{
                        right=mid;
                    }
                }
            }
        }

        return -1;
    }
}
