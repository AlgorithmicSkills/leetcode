package com.antonromanov.algorithms.binarysearch.ispalindrome;

public class IsPalindrome {
    public  static boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        char[] ss = s.toCharArray();

        int start = 0;
        int end = ss.length-1;

        while (start<end){
            if (ss[start]!=ss[end]){
                return false;
            }
            start = start+1;
            end = end-1;
        }
        return true;
    }
}
