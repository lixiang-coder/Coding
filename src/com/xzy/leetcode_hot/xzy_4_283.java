package com.xzy.leetcode_hot;

public class xzy_4_283 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes2(arr);
    }

    //暴力双指针
    public static void moveZeroes1(int[] nums) {
        // i慢指针：找为 0 的元素
        for (int i = 0; i < nums.length; i++) {
            // j快指针：用来找非0的元素
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == 0 && nums[j] != 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        //System.out.println(Arrays.toString(nums));
    }


    public static void moveZeroes2(int[] nums) {
        //慢指针：跟踪最后一个非零元素的位置
        int slow = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[slow] = nums[i];
                slow++;
            }
        }

        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }

        //System.out.println(Arrays.toString(nums));
    }
}
