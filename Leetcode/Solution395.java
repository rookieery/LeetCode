package LeetCode;

public class Solution395 {
    /**
     * 395. 至少有K个重复字符的最长子串
     * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。
     * 输出 T 的长度。
     */
    //递归+分治（类似归并排序）
    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        if (k < 2) {
            return s.length();
        }
        return GetMaxLength(s, k, 0, s.length() - 1);
    }

    private int GetMaxLength(String s, int k, int left, int right) {
        if (right - left + 1 < k) {
            return 0;
        }
        int[] chs = new int[26];
        for (int i = left; i <= right; i++) {
            chs[s.charAt(i) - 'a']++;
        }
        while (right - left + 1 >= k && chs[s.charAt(left) - 'a'] < k) {
            left++;
        }
        while (right - left + 1 >= k && chs[s.charAt(right) - 'a'] < k) {
            right--;
        }
        if (right - left + 1 < k) {
            return 0;
        }
        for (int i = left; i <= right; i++) {
            if (chs[s.charAt(i) - 'a'] < k) {
                return Math.max(GetMaxLength(s, k, left, i - 1), GetMaxLength(s, k, i + 1, right));
            }
        }
        return right - left + 1;
    }
}
