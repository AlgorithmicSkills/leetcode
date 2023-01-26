package com.antonromanov.algorithm.leetcode.easy.t1588.sumofalloddlength;

public class Solution {
    public static int sumOddLengthSubarrays(int[] arr) {
        Integer resultSum = 0;
        int processingArrayLength = 1;
        int stepMax = arr.length;
        while (processingArrayLength <= stepMax) {

            if (!(processingArrayLength % 2 == 0)) {
                for (int i = 0; i < arr.length; i++) {
                    resultSum = resultSum + getCut(i, processingArrayLength, arr);
                }
            }
            processingArrayLength = processingArrayLength + 1;
        }
        return resultSum;
    }

    private static Integer getCut(int i, int processingArrayLength, int[] arr) {
        int localSum = 0;
        if (i + processingArrayLength <= arr.length) {
            for (int j = i; j < i + processingArrayLength; j++) {
                localSum = localSum + arr[j];
            }
        }
        return localSum;
    }
}
