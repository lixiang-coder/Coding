package com.xzy.Test;


/**
 * 基本查找
 */
public class test02 {
    public static void main(String[] args) {
        int[] arr = {131, 127, 147, 81, 103, 23, 7, 79};
        int number = 81;

        long start = System.currentTimeMillis();
        System.out.println(baseSearch(arr, number));
        long end = System.currentTimeMillis();

        System.out.println("花费了；" + (end - start) + "ms");

    }

    /**
     * 基本查找
     *
     * @param arr    目标数组
     * @param number 目标数字
     * @return 返回索引
     */
    public static int baseSearch(int[] arr, int number) {
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == number) {
                return index;
            }
        }
        //未找到索引，直接返回-1，表示不存在
        return -1;
    }
}
