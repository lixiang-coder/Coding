package com.xzy.代码随想录.字符串;

public class Test5 {
    public static void main(String[] args) {
        String s = "aba";
        System.out.println(repeatedSubstringPattern(s));
    }

    /**
     * 力扣 459
     * https://leetcode.cn/problems/repeated-substring-pattern/description/
     *
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s) {
        // 思路：将原来的子串翻倍，掐头去尾得到新串，判断新串中有没有子窜
        StringBuilder sb = new StringBuilder();

        StringBuilder str = sb.append(s).append(s);

        String substring = str.substring(1, str.length() - 1);

        return substring.toString().contains(s);
    }
}
