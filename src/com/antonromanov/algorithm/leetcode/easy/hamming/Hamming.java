package com.antonromanov.algorithms.some.easy.hamming;

public class Hamming {
    public static int solve(int n) {

        int result = 0;
        while (n != 0) {
            result += n & 1;
            n >>>= 1;
        }
        return result;
    }

}
