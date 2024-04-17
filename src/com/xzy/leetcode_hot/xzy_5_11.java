package com.xzy.leetcode_hot;

public class xzy_5_11 {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea2(arr));

    }

    //双指针：大佬的思路就是牛逼啊
    public static int maxArea1(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;

        while (i < j) {
            //移动短板，面积才有可能增加
            //移动长板，面积一定减少
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) :
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

    //暴力一下：遍历出所有结果收集，取最大值
    public static int maxArea2(int[] height) {
        //盛水量为：两块板子的距离乘上低板子的高度
        int res = 0;
        int temp = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if (height[i] < height[j]){
                    temp = (j - i) * height[i];
                    res = Math.max(res,temp);
                }else {
                    temp = (j - i) * height[j];
                    res = Math.max(res,temp);
                }
            }
        }

        return res;
    }


}
