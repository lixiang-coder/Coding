package com.xzy.代码随想录.数组;

import java.io.Serializable;
import java.util.IdentityHashMap;

/**
 * 二分查找
 */
public class Test1 {
    public static void main(String[] args) {
        int[] arr = {5,};
        int search = search2(arr, 5);
        System.out.println(search);
    }

    public static int search1(int[] nums, int target) {
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return res;
    }

    // 二分法
    public static int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] > target){
                right = mid - 1;
                continue;
            }
            if (nums[mid] < target){
                left = mid + 1;
                continue;
            }
            if (nums[mid] == target){
                return mid;
            }
        }

        return -1;
    }
}
