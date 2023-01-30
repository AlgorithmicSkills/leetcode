package com.antonromanov.algorithm.leetcode.easy.t1572.matrixdiagonalsum;

public class Solution {
    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        int y = -1;
        int y1 = mat[mat.length - 1].length;
        int x = 0;
        boolean stop = false;
        while (!stop) {
            y = y + 1;
            y1 = y1 - 1;
            x = x + 1;

            int numberFromFirstDiagonal = mat[x - 1][y];
            int numberFromSecondDiagonal = (y == y1) ? 0 : mat[x - 1][y1];
            sum = sum + numberFromFirstDiagonal + numberFromSecondDiagonal;


            if (x == mat.length && y == (mat[x - 1].length) - 1) {
                stop = true;
            }
        }
        return sum;
    }
}
