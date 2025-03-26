package com.xzy.代码随想录.数组;

public class Tset4 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int res = minSubArrayLen(7, arr);

        System.out.println(res);


    }

    /**
     * 力扣 209
     * https://leetcode.cn/problems/minimum-size-subarray-sum/
     *
     * @param target 正整数
     * @param nums   数组
     * @return 长度
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int len = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];

                if (sum >= target) {
                    len = j - i + 1;
                    res = res < len ? res : len;

                    break;
                }
            }
        }

        return res == Integer.MAX_VALUE ? 0 : len;
    }
}
