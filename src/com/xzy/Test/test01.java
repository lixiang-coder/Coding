package com.xzy.Test;

/**
 * 面试题
 */
public class test01 {
    public static void main(String[] args) {
        // 示例字符串数组
        String[] strings = {"apple", "banana", "cherry", "strawberry", "blueberry"};
        // 调用方法找出最长的字符串
        String longestString = getMaxLen(strings);
        // 输出最长的字符串
        System.out.println("The longest string is: " + longestString);
    }

    // kimi写法
    public static String findLongestString(String[] strings) {
        if (strings == null || strings.length == 0) {
            return ""; // 如果数组为空或为null，返回空字符串
        }
        String longest = strings[0]; // 假设第一个字符串是最长的
        for (String str : strings) {
            if (str.length() > longest.length()) {
                longest = str; // 如果当前字符串更长，则更新最长字符串
            }
        }
        return longest; // 返回找到的最长字符串
    }

    //@author xzy
    public static String getMaxLen(String[] strs){
        String str = "";

        for (String s : strs) {
            if (s.length() > str.length()){
                str = s;
            }
        }
        return str;
    }

}
