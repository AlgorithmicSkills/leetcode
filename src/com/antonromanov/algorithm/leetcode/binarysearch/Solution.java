package com.antonromanov.algorithms.binarysearch;

public class Solution extends GuessGame {

    public static int guessNumber(int n) {
         return guessNumber1(0, n);
    }


    public static int guessNumber1(int start, int n) {
        if (n == 1) {
            return 1;
        }
        int mid = start+((n-start) / 2);

        if (guess(mid) == 0) {
            return mid;
        } else if (guess(mid) == 1){ // mid меньше загаданного числа
            return guessNumber1(mid+1,n);
        } else { // mid больше загаданного числа
            return guessNumber1(start, mid-1);
        }
    }
}

