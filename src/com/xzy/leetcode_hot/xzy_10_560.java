package com.xzy.leetcode_hot;

public class xzy_10_560 {
    public static void main(String[] args) {
        int[] arr = {1, -1, 0};
        int k = 0;
        System.out.println(subarraySum1(arr, k));
    }


    //暴力
    public static int subarraySum1(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for (int left = 0; left < len; left++) {
            int sum = 0;

            for (int right = left; right < len; right++) {
                sum += nums[right];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

}
