package LeetCode;

public class Solution3 {
    /**无重复字符的最长字串
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 1;
        int front = 0;
        int last = 1;
        char[] ch = new char[s.length()];
        ch[0] = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            int a = 0;
            for (int j = front; j < last; j++) {
                if (ch[j] == s.charAt(i)) {
                    ch[last++] = s.charAt(i);
                    front = j + 1;
                    a = 1;
                    break;
                }
            }
            if (a == 0) {
                ch[last++] = s.charAt(i);
            }
            max = Math.max(max,last - front);
        }
        return max;
    }
}
