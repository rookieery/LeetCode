package LeetCode;

public class Solution152 {
    /**
     * 152. 乘积最大子序列
     * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
     */
    //动规
    public int maxProduct(int[] nums) {
        int a = nums.length;
        if(a==0) {
            return 0;
        }
        int[][] dp = new int[a][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int max = nums[0];
        for(int i=1;i<a;i++) {
            int tmp1 = dp[i-1][0]*nums[i];
            int tmp2 = dp[i-1][1]*nums[i];
            dp[i][0] = Math.max(nums[i],Math.max(tmp1,tmp2));
            dp[i][1] = Math.min(nums[i],Math.min(tmp1,tmp2));
            max = Math.max(max,dp[i][0]);
        }
        return max;
    }
}
