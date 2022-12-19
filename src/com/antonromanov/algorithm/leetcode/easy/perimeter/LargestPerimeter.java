package com.antonromanov.algorithms.some.easy.perimeter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestPerimeter {



    public static int largestPerimeter2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = nums.length-1; i > 1; i--) {

            if (nums[i]<nums[i-1]+nums[i-2]){
                res.add(nums[i]+nums[i-1]+nums[i-2]);
            }
        }
        if (res.isEmpty()) {
            return 0;
        } else {
            return res.stream().max(Integer::compareTo).get();
        }
    }

    public static int largestPerimeter(int[] nums) {

        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {

            int itJ = nums.length - 1;
            boolean flagJ = false;
            while (itJ > 0) {
                if (itJ != i) {
                    int it = nums.length - 1;
                    boolean flag = false;
                    while (!flag && it > 0) {
                        if (it != itJ && it != i) {
                            Integer perimeter = nums[i] + nums[itJ] + nums[it];
                            double semiPerimeter = (double) perimeter / 2;
                            double s = semiPerimeter * (semiPerimeter - nums[i]) * (semiPerimeter - nums[itJ]) * (semiPerimeter - nums[it]);
                            if (s <= 0) {
                                it = it - 1;
                            } else {
                                res.add(perimeter);
                                flag = true;
                            }

                        } else {
                            it = it - 1;
                        }
                    }
                    itJ = itJ - 1;
                } else {
                    itJ = itJ - 1;
                }
            }
        }

        if (res.isEmpty()) {
            return 0;
        }
        int result = res.stream().max(Integer::compareTo).get();
        if (result < 1) {
            return 0;
        } else {
            return result;
        }
    }
}
