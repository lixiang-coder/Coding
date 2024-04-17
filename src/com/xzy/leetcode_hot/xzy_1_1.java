package com.xzy.leetcode_hot;

import java.util.Arrays;

public class xzy_1_1 {
    public static void main(String[] args) {
        int[] arr = {3,3};
        int num = 6;
        int[] ints = twoSum(arr, num);
        System.out.println(Arrays.toString(ints));
    }

    //双指针
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        //快指针
        for (int i = 0; i < nums.length; i++) {
            //慢指针
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}
