package LeetCode;

public class Solution32 {
    //32.最长有效括号
    //给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
    //找不到合适的计数工具，不如就把字符串的下标放入栈，还能计数。
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] stack = new int[s.length() + 1];
        stack[0] = -1;
        int maxnum = 0;
        int top = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack[top++] = i;
            } else {
                top--;
                if (top == 0) {
                    stack[top++] = i;
                } else {
                    maxnum = Math.max(maxnum, i - stack[top - 1]);
                }
            }
        }
        return maxnum;
    }
}
