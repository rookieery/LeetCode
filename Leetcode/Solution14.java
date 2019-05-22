package LeetCode;

public class Solution14 {
    //最长公共前缀
    //编写一个函数来查找字符串数组中的最长公共前缀。
    //如果不存在公共前缀，返回空字符串 ""。
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        for (String str : strs) {
            if (str.equals("")) {
                return "";
            }
        }
        char[] chars = new char[strs[0].length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = strs[0].charAt(i);
        }
        for (int i = 0; i < chars.length; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length()) {
                    chars[i] = ' ';
                    continue;
                }
                if (i < strs[j].length() && strs[j].charAt(i) != chars[i]) {
                    chars[i] = ' ';
                }
            }
        }
        int count = 0;
        while (chars[count] != ' ') {
            count++;
            if (count == chars.length) {
                break;
            }
        }
        return new String(chars, 0, count);
    }
}
