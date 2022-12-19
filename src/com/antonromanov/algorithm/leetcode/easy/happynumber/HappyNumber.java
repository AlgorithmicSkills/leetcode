package com.antonromanov.algorithms.some.easy.happynumber;

import java.util.HashSet;

public class HappyNumber {
    public static boolean isHappy(int n) {
        HashSet<Integer> h = new HashSet<>();
        return recursiveCalc(h, n);
    }

    private static boolean recursiveCalc(HashSet<Integer> h, int number) {

        while (!h.contains(number) && number != 1) {
            h.add(number);
            char[] arr = toCharArr(number);
            Integer res = 0;
            for (Character ch : arr) {
                res = res + (Integer.parseInt(String.valueOf(ch)) * Integer.parseInt(String.valueOf(ch)));
            }
            System.out.println("res = " + res);
            return recursiveCalc(h, res);
        }
        if (number == 1) {
            return true;
        }

        return false;

    }

    private static char[] toCharArr(int number) {
      String z = String.valueOf(number);
      return z.toCharArray();
    }
}
