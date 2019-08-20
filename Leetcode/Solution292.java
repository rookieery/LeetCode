package LeetCode;

import java.util.Arrays;

public class Solution292 {
    /**
     * 292. Nim 游戏
     */
    //动规
    public boolean canWinNim1(int n) {
        boolean[] dp = new boolean[n];
        Arrays.fill(dp, true);
        for (int i = 4; i < n; i++) {
            dp[i] = !dp[i - 1] || !dp[i - 2] || !dp[i - 3];
        }
        return dp[n-1];
    }
    //巴什博奕，n%(m+1)!=0时，先手总是会赢的
    public boolean canWinNim2(int n) {
        return n%4!=0;
    }
}
