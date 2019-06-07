package LeetCode;

public class Solution151 {
    /**
     *151. 翻转字符串里的单词
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     */
    public String reverseWords(String s) {
        if (s.length() == 0) {
            return s;
        }
        StringBuilder str = new StringBuilder();
        int a = s.length() - 1;
        int b = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if ((i == s.length() - 1 && s.charAt(i) != ' ') || (s.charAt(i) != ' ' && s.charAt(i + 1) == ' ')) {
                a = i;
            }
            if (i < a && s.charAt(i) == ' ' && s.charAt(i + 1) != ' ') {
                str.append(s.substring(i + 1, a + 1));
                str.append(" ");
                b = 1;
            }
            if (i == 0 && s.charAt(i) != ' ') {
                str.append(s.substring(i,a + 1));
                b = 1;
            }
        }
        if (b == 0) {
            return "";
        }
        if (str.charAt(str.length() - 1) == ' ') {
            str.delete(str.length() - 1,str.length());
        }
        return str.toString();
    }
}
