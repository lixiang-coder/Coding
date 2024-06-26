package com.xzy.leetcode_hot;


public class xzy_7_42 {
    public static void main(String[] args) {
        int[] arr = {4, 2, 0, 3, 2, 5};
        System.out.println(trap2(arr));
    }

    //暴力解法
    public static int trap1(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            //剪枝：第一个柱子和最后一个柱子不接雨水
            if (i == 0 || i == height.length - 1) {
                continue;
            }

            int leftHeight = height[i];     // 记录左边柱子的最高高度
            int rightHeight = height[i];    // 记录右边柱子的最高高度

            //找到柱子 i 右边最高的柱子
            for (int r = i + 1; r < height.length; r++) {
                if (height[r] > rightHeight) {
                    rightHeight = height[r];
                }
            }

            //找到柱子 i 左边最高的柱子
            for (int l = i - 1; l >= 0; l--) {
                if (height[l] > leftHeight) {
                    leftHeight = height[l];
                }
            }

            //柱子i这一列所接雨水 = 左边柱子和右边柱子中取较小的 - 柱子i本身的高度
            int h = Math.min(leftHeight, rightHeight) - height[i];
            if (h > 0) {
                sum = sum + h;
            }
        }

        return sum;
    }


    //双指针优化暴力
    public static int trap2(int[] height) {
        //剪枝
        if (height.length <= 2) return 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        // 记录每个柱子左边柱子最大高度
        maxLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }

        // 记录每个柱子右边柱子最大高度
        maxRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }

        //求和
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int count = Math.min(maxLeft[i], maxRight[i] - height[i]);
            if (count > 0) {
                sum = sum + count;
            }
        }
        return sum;
    }
}
