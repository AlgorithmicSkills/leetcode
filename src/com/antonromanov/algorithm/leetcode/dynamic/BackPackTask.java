package com.antonromanov.algorithm.leetcode.dynamic;

/**
 * Задача о рюкзаке.
 */
public class BackPackTask {
    int[] weights = {3, 4, 5, 8, 9};
    int[] prices = {1, 6, 4, 7, 6};
    // int count = weights.length;
    int maxWeight = 13;
   // long count = 2L << weights.length;
    int count = weights.length;
    int maxPrice = 0;
    long maxState = 0;

    public void calc() {
        for (long state = 0; state < count; state++) {
            int price = statePrice(state, prices);
            int weight = stateWeight(state, weights);
            if (weight <= maxWeight) {
                if (maxPrice < price) {
                    maxPrice = price;
                    maxState = state;
                }
            }
        }
        System.out.println("Оптимальное содержимое рюкзака");
        long powerOfTwo = 1;
        for (int i = 0; i < weights.length; i++) {

            if ((powerOfTwo & maxState) > 0) {
                System.out.println(i + 1);
            }
            powerOfTwo <<= 1;
        }
    }

    private int  stateWeight(long state, int[] weights) {

        long powerOfTwo = 1;
        int weight = 0;
        for (int i = 0; i < weights.length; i++) {

            if ((powerOfTwo & state) != 0) {
                weight+=weights[i];
            }
            powerOfTwo <<= 1;
        }
        return weight;
    }

    private int  statePrice(long state, int[] prices) {

        long powerOfTwo = 1;
        int price = 0;
        for (int i = 0; i < prices.length; i++) {
            if ((powerOfTwo & state) != 0) {
                price+=prices[i];
            }
            powerOfTwo <<= 1;
        }
        return price;
    }


    public void dynamicCalc(){
        int[][]A;
        A = new int[count+1][];

        for (int i=0; i<count; i++){
            A[i] = new int[maxWeight+1];
        }

        for (int k=0; k<count; k++){
            for (int s=0; s<maxWeight; s++) {
                if (k==0 || s==0){
                    A[k][s]=0;
                } else {
                    if (s>=weights[k-1]){
                        A[k][s]=Math.max(A[k-1][s], A[k-1][s-weights[k-1]]+prices[k-1]);
                    } else {
                        A[k][s]=A[k-1][s]=0;
                    }
                }
            }
        }
    }

}
