package LeetCode;

public class Solution917 {
    /**
     * 917. 仅仅反转字母
     * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
     */
    public String reverseOnlyLetters(String S) {
        StringBuilder sb1 = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            char ch = S.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                sb1.append(ch);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        int index = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                sb2.append(sb1.charAt(index++));
            } else {
                sb2.append(ch);
            }
        }
        return sb2.toString();
    }
}
