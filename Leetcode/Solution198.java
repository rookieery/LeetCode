package LeetCode;

public class Solution198 {
    /**
     *198. 打家劫舍
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
     * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     */
    //动态规划
    //状态转移方程1：dp[i] = Math.max(dp[i-2]+nums[i],dp[i-3]+nums[i-1])
    public int rob1(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return nums[0]>nums[1]?nums[0]:nums[1];
        }
        if(nums.length == 3) {
            int tmp = nums[0]+nums[2];
            return tmp>nums[1]?tmp:nums[1];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        dp[2] = Math.max(nums[1],nums[0]+nums[2]);
        for(int i = 3;i<nums.length;i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-3]+nums[i-1]);
        }
        return dp[nums.length-1];
    }
    //状态转移方程2:dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i])
    public int rob2(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return nums[0]>nums[1]?nums[0]:nums[1];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<nums.length;i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}
