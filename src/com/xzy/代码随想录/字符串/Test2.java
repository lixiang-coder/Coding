package com.xzy.代码随想录.字符串;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        String s = "abcdefg";
        String res = reverseStr(s, 8);
        System.out.println(res);

    }


    /**
     * 力扣 541
     * https://leetcode.cn/problems/reverse-string-ii/description/
     *
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();

        // 每次截取2k个，反转k个
        for (int i = 0; i < charArray.length; i += 2 * k) {
            // 1.获取要反转的字符数组，筛选合适的长度
            int start = i;
            int end = Math.min(s.length() - 1, i + k - 1);
            // 2.直接调用reverseString方法进行反转
            reverseString(charArray, start, end);
        }

        // 3. 返回
        return new String(charArray);
    }


    /**
     * 反转字符数组
     *
     * @param s     字符数组
     * @param start 起始索引
     * @param end   终止索引
     */
    public static void reverseString(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
