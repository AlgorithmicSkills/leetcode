package com.antonromanov.algorithms.some.easy.movezeroes;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int pointerOne = 0;
        int pointerTwo = nums.length - 1;
        int last = nums.length - 1;

        while (pointerOne <= pointerTwo) {

            if (nums[pointerOne] == 0) {
                for (int i = pointerOne; i < nums.length-1; i++) {
                    nums[i] = nums[i + 1];
                }
                nums[last] = 0;
            }
            if (nums[pointerTwo] == 0) {
                pointerTwo--;
            }
            if (nums[pointerOne] != 0) {
                pointerOne++;
            }
        }
        System.out.println(nums);
    }
}
