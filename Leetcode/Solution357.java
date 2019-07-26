package LeetCode;

public class Solution357 {
    /**
     * 357. 计算各个位数不同的数字个数
     * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10^n。
     */
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) {
            return 1;
        }
        int[] dp=new int[n];
        dp[0]=10;
        int mul=9;
        int tmp=10;
        for(int i=1;i<n;i++) {
            mul *= (tmp---1);
            dp[i]=dp[i-1]+mul;
        }
        return dp[n-1];
    }
}
