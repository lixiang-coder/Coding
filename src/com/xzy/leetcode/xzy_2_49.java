package com.xzy.leetcode;

import java.util.*;

public class xzy_2_49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            //将每个字符串进行排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedstr = new String(chars);

            //从map中获取键为sortedstr的列表，如果不存在，则创建一个新的集合
            //如果存在，则list被赋值为value = map.getKey(sortedstr)
            List<String> list = map.getOrDefault(sortedstr,new ArrayList<>());
            list.add(str);
            map.put(sortedstr,list);
        }
        return new ArrayList<>(map.values());
    }

}
