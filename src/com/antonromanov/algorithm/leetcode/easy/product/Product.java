package com.antonromanov.algorithms.some.easy.product;

public class Product {
    public static int subtractProductAndSum(int n) {
        String s = String.valueOf(n);
        char[] chArr = s.toCharArray();
        Integer mult = null;
        int sum = 0;

        int sum1 = 0, mul = 1;
        while (n > 0) {
            int d = n % 10;
            sum1 += d;
            mul *= d;
            n /= 10;
        }

        for (char c : chArr) {
            int localInt = Integer.parseInt(String.valueOf(c));

           if (mult==null){
               mult=localInt;
           } else {
               mult = mult * localInt;
           }
            sum = sum + localInt;
        }

        return mult-sum;
    }
}
