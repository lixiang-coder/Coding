package com.xzy.代码随想录.数组;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(Arrays.toString(removeElement2(arr, 2)));

    }

    // 暴力
    public static int removeElement1(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                size--;
                i--;
            }
        }
        return size;
    }

    public static int[] removeElement2(int[] nums, int val) {
        int slow = 0;
        int len = 0;
        // 因为不知道这个数组有多大
        int[] arr = new int[1000];

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                arr[slow] = nums[fast];
                slow++;
                len = slow;
            }
        }

        int[] res = Arrays.copyOf(arr, len);
        return res;
    }

    /**
     * 双指针法
     * 快指针：筛选那些不是目标值的数字
     * 慢指针：将筛选的数字重新放入数组中
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement3(int[] nums, int val) {
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        return slow;
    }
}
