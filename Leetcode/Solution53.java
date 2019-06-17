package LeetCode;

public class Solution53 {
    /**
     * 53. 最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     */
    //动态规划
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length;i++) {
            if(sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(max,sum);
        }
        return max;
    }
    //另法 规律：dp[i] = max(dp[i-1] + nums[i], nums[i])
}
