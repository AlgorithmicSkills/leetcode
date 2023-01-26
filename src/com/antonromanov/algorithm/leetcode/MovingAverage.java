package com.antonromanov.algorithm.leetcode;

import java.util.*;

public class MovingAverage {
    public final int size;
    Queue<Integer> store = new LinkedList<>();

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {

        store.add(val);
        if (store.size() > size){
            store.poll();
        }

        int preAverage = 0;
        preAverage = store.stream().reduce(Integer::sum).get();
        return  (double) preAverage / store.size();
    }
}
