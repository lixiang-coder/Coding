package com.xzy.leetcode_hot;

import java.util.*;

public class xzy_6_15 {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum2(arr));

    }

    //暴力
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return res;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (k > j + 1 && nums[k - 1] == nums[k]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 先对数组进行排序
        Arrays.sort(nums);

        // 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]

        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) { // 去重a
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;


            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum > 0) { // 和有点大，故将right往左移动
                    right--;
                }

                if (sum < 0) { // 和有点小，故将left往右移动
                    left++;
                }

                if (sum == 0) { // 满足要求
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 去重逻辑应该放在找到一个三元组之后，对 b 和 c 去重
                    while (right > left && nums[right] == nums[right - 1])
                        right--;
                    while (right > left && nums[left] == nums[left + 1])
                        left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
