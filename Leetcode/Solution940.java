package LeetCode;

import java.util.Arrays;

public class Solution940 {
    /**
     * 940. 不同的子序列 II
     * 给定一个字符串 S，计算 S 的不同非空子序列的个数。
     */
    //动规（dp[k] = 2 * dp[k - 1] - dp[last[S[k]] - 1]）
    public int distinctSubseqII(String S) {
        int MOD = 1000000007;
        int N = S.length();
        int[] dp = new int[N + 1];
        dp[0] = 1;
        //计数数组
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < N; i++) {
            int x = S.charAt(i) - 'a';
            dp[i + 1] = 2 * dp[i] % MOD;
            if (last[x] >= 0) {
                dp[i + 1] -= dp[last[x]];
            }
            dp[i + 1] %= MOD;
            last[x] = i;
        }
        dp[N]--;
        if (dp[N] < 0) {
            dp[N] += MOD;
        }
        return dp[N];
    }
}
