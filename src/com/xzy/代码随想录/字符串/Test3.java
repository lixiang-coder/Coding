package com.xzy.代码随想录.字符串;

public class Test3 {
    public static void main(String[] args) {
        String str = "a good   example";
        String s = reverseWords(str);
        System.out.println(s);
    }

    /**
     * 力扣 151
     * https://leetcode.cn/problems/reverse-words-in-a-string/description/
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        // 1.前置操作：需要删除前中后多余的空格
        String removedSpace = removeSpace(s);

        // 2.将字符串整体串反转
        String reverseStr = reverseStr(removedSpace);

        // 3.反转每一个单词
        return reverseWord(reverseStr);
    }

    /**
     * 删除前中后多余空格
     *
     * @param s
     * @return
     */
    public static String removeSpace(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strings = s.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (!strings[i].equals("")) {
                sb.append(strings[i] + " ");
            }
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }


    /**
     * 反转字符串
     *
     * @param s
     * @return
     */
    public static String reverseStr(String s) {
        int start = 0;
        int end = s.length() - 1;

        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            while (start < end) {
                char temp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = temp;
                start++;
                end--;
            }
        }
        return new String(charArray);
    }


    /**
     * 反转单词
     *
     * @param s
     * @return
     */
    public static String reverseWord(String s) {
        StringBuilder sb = new StringBuilder();

        String[] words = s.split(" ");

        for (String word : words) {
            String reversWord = reverseStr(word);
            sb.append(reversWord + " ");
        }
        // 删除最后一个空格
        sb.deleteCharAt(sb.length() - 1);

        return new String(sb);
    }

}
