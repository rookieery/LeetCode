package LeetCode;

public class Solution70 {
    /**
     * 70. 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     */
    public int climbStairs1(int n) {
        int sum1 = 1;
        int sum2 = 2;
        for (int i = 1; i < n; i++) {
            int tmp = sum2;
            sum2 += sum1;
            sum1 = tmp;
        }
        return sum1;
    }
    //动态规划
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
