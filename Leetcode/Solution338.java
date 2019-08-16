package LeetCode;

public class Solution338 {
    /**
     * 338. 比特位计数
     * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，
     * 计算其二进制数中的 1 的数目并将它们作为数组返回。
     */
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            dp[i] = dp[i >> 1] + (i & 1);
        return dp;
    }
}
