package com.antonromanov.algorithms.binarysearch;

public class GuessGame {
   private final static int pick = 3;

    public static int guess(int i){
        if (i>pick) {
            return -1;
        } else if (i<pick){
            return 1;
        } else  {
            return 0;
        }
    }
}
