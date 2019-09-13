package LeetCode;

public class Solution392 {
    //392.判断子序列
    //给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
    //你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
    //字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
    // （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
    public boolean isSubsequence(String s, String t) {
        char[] queue1 = s.toCharArray();
        char[] queue2 = t.toCharArray();
        int top = 0;
        if (queue1.length == 0) {
            return true;
        }
        for (int i = 0; i < queue2.length; i++) {
            if (top != queue1.length-1 && queue2[i] == queue1[top]) {
                top++;
                continue;
            }
            if (top == queue1.length-1 && queue2[i] == queue1[top]) {
                top++;
                break;
            }
        }
        if (top == queue1.length) {
            return true;
        }
        return false;
    }

    public boolean isSubsequence1(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(count) == t.charAt(i)) {
                count++;
            }
            if (count == s.length()) {
                return true;
            }
        }
        return false;
    }
    public boolean isSubsequence2(String s, String t) {
        int index = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            index = t.indexOf(ch[i],index);
            if (index == -1) {
                return false;
            }
            index++;
        }
        return true;
    }
}
