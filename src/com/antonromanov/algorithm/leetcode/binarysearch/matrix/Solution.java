package com.antonromanov.algorithms.binarysearch.matrix;

import java.util.Arrays;

public class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {

       return recursiveBinarySearch(matrix,target, 0, matrix.length-1);
    }

    private static boolean recursiveBinarySearch(int[][] matrix, int target, int start, int end) {

        if (start==end){
            return Arrays.stream(matrix[start]).anyMatch(e->e==target);
        }

        int s = start+((end-start)/2);
        int s2 = matrix[s].length;
        int value = matrix[s][s2-1];


        if (value==target) {
            return true;
        } else if (value<target){
            return recursiveBinarySearch(matrix, target, s+1, end);
        } else {
            return recursiveBinarySearch(matrix, target, start, s);
        }
    }
}
