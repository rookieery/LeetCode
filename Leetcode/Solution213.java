package LeetCode;

public class Solution213 {
    /**
     * 213. 打家劫舍 II
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
     * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     */
    //两部分动态规划
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return nums[0]>nums[1]?nums[0]:nums[1];
        }
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        int[] ap = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = nums[0]>nums[1]?nums[0]:nums[1];
        dp2[0] = nums[1];
        dp2[1] = nums[1]>nums[2]?nums[1]:nums[2];
        for(int i=2;i<nums.length-1;i++) {
            dp1[i] = Math.max(dp1[i-1],nums[i]+dp1[i-2]);
            dp2[i] = Math.max(dp2[i-1],nums[i+1]+dp2[i-2]);
        }
        return Math.max(dp1[nums.length-2],dp2[nums.length-2]);
    }
}
