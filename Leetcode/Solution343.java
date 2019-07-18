package LeetCode;

public class Solution343 {
    /**
     * 343. 整数拆分
     * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
     */
    //动态规划
    public int integerBreak1(int n) {
        int[] dp=new int[59];
        dp[2]=1;
        dp[3]=2;
        dp[4]=4;
        dp[5]=6;
        dp[6]=9;
        for(int i=7;i<=n;i++) {
            for(int j=i-1;j>=i/2;j--) {//i/2是一种优化
                dp[i] = Math.max(dp[i],dp[j]*(i-j));
            }
        }
        return dp[n];
    }
    //数学 3m+2n
    public int integerBreak2(int n) {
        if(n==2||n==3) {
            return n-1;
        }
        int res=1;
        while(n>4){
            res*=3;
            n-=3;
        }
        return res*n;
    }
}
