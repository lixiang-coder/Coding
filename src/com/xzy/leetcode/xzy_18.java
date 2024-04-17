package com.xzy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class xzy_18 {
    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        int num = 0;
        System.out.println(fourSum(arr, num));
    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //剪枝
            if (nums[i] > 0 && nums[i] > target) {
                continue;
            }

            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int k = i + 1; k < nums.length; k++) {
                //再剪枝
                if (nums[k] > 0 && nums[i] + nums[k] > target) {
                    continue;
                }

                //再去重
                if (k > i + 1 && nums[k] == nums[k - 1]) {
                    continue;
                }

                int left = k + 1;
                int right = nums.length - 1;


                while (right > left) {
                    int sum = nums[i] + nums[k] + nums[left] + nums[right];

                    if (sum > target) { // 和有点大，故将right往左移动
                        right--;
                    }

                    if (sum < target) { // 和有点小，故将left往右移动
                        left++;
                    }

                    if (sum == target) { // 满足要求
                        result.add(Arrays.asList(nums[i], nums[k], nums[left], nums[right]));

                        // 去重逻辑应该放在找到一个四元组之后，对 left 和 right 去重
                        while (right > left && nums[right] == nums[right - 1])
                            right--;
                        while (right > left && nums[left] == nums[left + 1])
                            left++;

                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
