package com.xzy.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class xzy_3_128 {
    public static void main(String[] args) {
        //int[] arr = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive1(arr));
    }


    //双指针暴力超时
    public static int longestConsecutive1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        //数组去重
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int[] temp = new int[set.size()];
        int tempIndex = 0;
        for (Integer num : set) {
            temp[tempIndex++] = num;
        }


        Arrays.sort(temp);
        int maxlen = 0;
        int index = 0;

        for (int i = 0; i < temp.length; i++) {
            int count = 0;
            index = i;
            for (int j = index + 1; j < temp.length; j++) {
                if (temp[j] - temp[index] != 1) {
                    break;
                }
                count++;
                index++;
                maxlen = Math.max(maxlen, count);
            }
        }

        return maxlen + 1;
    }


    /*public static int longestConsecutive2(int[] nums) {

    }*/
}
