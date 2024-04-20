package com.xzy.leetcode_hot;


import java.util.*;

public class xzy_8_3 {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(lengthOfLongestSubstring2(s));

    }

    //滑动窗口
    public static int lengthOfLongestSubstring1(String s) {
        //剪枝
        if (s.length() < 2) {
            return s.length();
        }

        //定义窗口的最大值
        int longestLength = 0;
        //定义左右指针
        int left = 0;
        int right = 0;
        //定义窗口字符集合
        Set<Character> set = new HashSet<>();

        //当左右指针到达边界值时结束循环
        while (left < s.length() && right < s.length()) {
            //判断窗口集合是否包含指针处字符
            if (set.contains(s.charAt(right))) {
                //包含就移除集合中指针处字符，并右移左指针
                set.remove(s.charAt(left));
                left++;
            } else {
                //不包含就将指针处字符添加到集合中，并右移右指针
                set.add(s.charAt(right));
                right++;
            }
            //更新窗口最大值
            if (set.size() > longestLength) {
                longestLength = set.size();
            }
        }
        return longestLength;

    }


    public static int lengthOfLongestSubstring2(String s) {
        //剪枝
        if (s.length() < 2) {
            return s.length();
        }

        int slow = 0;
        int len = 0;
        int maxlen = 0;

        Set<Character> set = new HashSet<>();

        for (int fast = 0; fast < s.length(); fast++) {
            //set集合中存在
            if (set.contains(s.charAt(fast))) {
                //将set集合中的这个字符删除
                set.remove(s.charAt(slow));
                fast--;
                len--;
                slow++;
            } else {
                //不存在
                set.add(s.charAt(fast));
                len++;
                maxlen = Math.max(len, maxlen);
            }
        }

        return maxlen;
    }

}
