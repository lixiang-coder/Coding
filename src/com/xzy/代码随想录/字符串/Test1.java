package com.xzy.代码随想录.字符串;

public class Test1 {

    /**
     * 力扣 344
     * https://leetcode.cn/problems/reverse-string/
     *
     * @param s
     */
    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
