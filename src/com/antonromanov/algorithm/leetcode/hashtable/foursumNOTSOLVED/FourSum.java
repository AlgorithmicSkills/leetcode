package com.antonromanov.algorithms.hashtable.foursumNOTSOLVED;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FourSum {


    // [-3,-2,-1,0,0,1,2,3]
    // [[-2,0,0,2],[-3,-1,1,3],[-3,0,0,3],[-2,-1,1,2],[-1,0,0,1],[-3,-2,2,3]]
    // [[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3] -> [-3,0,1,2] -> [-2,-1,0,3] -> [-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

    /*public static List<List<Integer>> fourSum(int[] nums, int target) {


        Arrays.sort( nums );
        Set<List<Integer>> result = new HashSet<>();

        int pointerOne = 0;
        int pointerTwo = nums.length - 1;

        while (pointerOne+1 < pointerTwo-1) {
            int internalStepLeft = 1;
            int internalStepRight = -1;
            int sum = 0;
            while (pointerOne+internalStepLeft < pointerTwo+internalStepRight) {

                // ========= two pointers ===========
                 sum = nums[pointerOne] + nums[pointerOne + internalStepLeft] + nums[pointerTwo] + nums[pointerTwo + internalStepRight];

                if (sum == target) {
                    List<Integer> list = Arrays.stream(Stream.of(nums[pointerOne],
                            nums[pointerOne+internalStepLeft],
                            nums[pointerTwo+internalStepRight],
                            nums[pointerTwo]).mapToInt(i -> i).toArray()).boxed().collect(Collectors.toList());
                    result.add(list);

                    internalStepLeft++;
                    internalStepRight--;
                } else if(sum<target){
                    internalStepLeft++;
                } else {
                    internalStepRight--;
                }

                // ===== kjnknjnk =====

            }

            sum = nums[pointerOne] + nums[pointerOne + 1] + nums[pointerTwo] + nums[pointerTwo -1];

            if(sum<target) {
                pointerOne++;
            }else if (sum == target) {
                pointerOne++;
                pointerTwo--;
            } else {
                pointerTwo--;
            }
        }

        return new ArrayList<>(result);
    }*/

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        // [-3,-2,-1,0,0,1,2,3]
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    for (int x = 0; x < nums.length; x++) {
                        if (x != j && x != i) {
                            for (int y = 0; y < nums.length; y++) {

                                if (y != j && y != i && y != x) {

                                    int localSum = nums[i] + nums[j] + nums[x] + nums[y];

                                    if (localSum == target) {
                                        List<Integer> list = Arrays.stream(Stream.of(nums[i], nums[j], nums[x], nums[y])
                                                .mapToInt(z -> z).toArray()).boxed().collect(Collectors.toList());
                                        Collections.sort(list);
                                        result.add(list);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

}
