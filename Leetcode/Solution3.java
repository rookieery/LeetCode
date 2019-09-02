package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    /**
     * 无重复字符的最长字串
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
            max = Math.max(max, last - front);
        }
        return max;
    }

    //滑动窗口
    public int lengthOfLongestSubstring1(String s) {
        Set<Character> set = new HashSet<>();
        int maxlen = 0;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxlen = Math.max(maxlen, j - i);
            } else {
                //此操作会一直持续到移除掉s.charAt(j++)为止
                set.remove(s.charAt(i++));
            }
        }
        return maxlen;
    }

    //滑动窗口（优化）
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
