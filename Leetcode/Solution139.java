package LeetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution139 {
    /**
     * 139. 单词拆分
     * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
     * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
     * 说明：
     * 拆分时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
     */
    //记忆回溯
    public boolean wordBreak(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }
    public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
    //动规
    public boolean wordBreak1(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return false;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    //动规优化
    public boolean wordBreak2(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return false;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int maxLength = 0;
        int minLength = s.length();
        for (String str : wordDict) {
            maxLength = Math.max(maxLength, str.length());
            minLength = Math.min(minLength,str.length());
        }
        //比minLength还小的长度一定不被包含
        for (int i = minLength; i <= s.length(); i++) {
            //使得截取出来的字符串最大长度为maxLength
            for (int j = Math.max(0, i - maxLength); j <= i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
