package com.xzy.Test;

/**
 * 二分查找
 */
public class test03 {
    public static void main(String[] args) {
        //核心：每次排除一半的查找范围

        //需求：定义一个方法利用二分查找，查询某个元素在数组中的索引
        //数据格式如下：{7, 23, 79, 81, 103, 127, 131, 147};

        int[] arr = {7, 23, 79, 81, 103, 127, 131, 147};
        int number = 5;

        int index = getIndex(arr, number);
        System.out.println(index);
    }


    /**
     * 二分查找
     *
     * @param arr    目标数组
     * @param number 目标数字
     * @return 返回索引
     */
    public static int getIndex(int[] arr, int number) {
        //1.定义两个变量记录min和max
        int min = 0;
        int max = arr.length - 1;
        int mid = (max + min) / 2;

        while (true) {
            //2.排除一些特殊情况
            if (min > max){
                return -1;
            }

            if (number > arr[mid]){
                //3.当number的值比mid的值大时，min = mid + 1
                min = mid + 1;
                mid = (max + min) / 2;
            }else if(number < arr[mid]){
                //4.当number的值比mid的值小时，max = mid - 1
                max = mid - 1;
                mid = (max + min) / 2;
            }else if (number == arr[mid]){
                return mid;
            }
        }
    }
}
