package com.xzy.leetcode_hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class xzy_9_438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    //暴力
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<Integer>();
        int sLen = s.length();
        int pLen = p.length();

        //剪枝
        if (sLen < pLen) {
            return ans;
        }

        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);

        for (int i = 0; i < sLen - pLen + 1; i++) {
            String substr = s.substring(i, i + pLen);
            char[] chars = substr.toCharArray();
            Arrays.sort(chars);

            if (Arrays.equals(chars, pArray)) {
                ans.add(i);
            }
        }
        return ans;

    }
}
