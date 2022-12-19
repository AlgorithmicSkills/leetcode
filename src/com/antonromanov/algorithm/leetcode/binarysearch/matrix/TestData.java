package com.antonromanov.algorithms.binarysearch.matrix;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestData {
    private final List<int[]> matrix = Arrays.asList(
            Stream.of(1,2,3).mapToInt(i->i).toArray(),
            Stream.of(5,6,7).mapToInt(i->i).toArray()
    );

   // private final int marks[][]={{50,60,55,67,70},{62,65,70,70,81},{72,66,77,80,69}};
    private final int marks[][]={{-9,-8,-8},{-5,-3,-2},{0,2,2}, {4,6,8}};

    public List<int[]> getMatrix() {
        return matrix;
    }

    public int[][] getMarks() {
        return marks;
    }
}
