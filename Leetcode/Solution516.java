package LeetCode;

public class Solution516 {
    /**
     * 516. 最长回文子序列
     * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
     */
    public int longestPalindromeSubseq(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];
        for (int i = dp.length - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < dp.length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][dp.length - 1];
    }
}
