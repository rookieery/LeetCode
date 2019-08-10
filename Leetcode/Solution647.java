package LeetCode;

public class Solution647 {
    /**
     * 647. 回文子串
     * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
     */
    //暴力动规
    public int countSubstrings1(String s) {
        int a = s.length();
        if (a == 0) {
            return 0;
        }
        int[] dp = new int[a];
        dp[0] = 1;
        for (int i = 1; i < a; i++) {
            int count = 0;
            for (int j = 0; j <= i; j++) {
                if (function(s.substring(j, i + 1))) {
                    count++;
                }
            }
            dp[i] = dp[i - 1] + count;
        }
        return dp[a - 1];
    }

    private boolean function(String t) {
        int i = 0;
        int j = t.length() - 1;
        while (i < j) {
            if (t.charAt(i) == t.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
    //中心扩展
    //马拉车
}
