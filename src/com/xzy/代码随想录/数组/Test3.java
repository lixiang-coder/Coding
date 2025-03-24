package com.xzy.代码随想录.数组;

import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 3, 10};
        int[] ints = sortedSquares(arr);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            double pow = Math.pow(nums[i], 2);
            arr[i] = (int) pow;
        }

        Arrays.sort(arr);
        return arr;
    }
}
