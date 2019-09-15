package LeetCode;

public class Solution53 {
    /**
     * 53. 最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     */
    //-2,1,-3,4,-1,2,1,-5,4 nums[]  6 = 4-1+2+1

    //-2,1,-2,4,3,5,6,1,5  dp[]     6
    // if(dp[i-1] < 0) -> dp[i] = nums[i];
    // else  -> dp[i] = dp[i-1] + nums[i];


    //动态规划
    public int maxSubArray1(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    //另法 规律：dp[i] = max(dp[i-1] + nums[i], nums[i])
    public int maxSubArray2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
//            if (dp[i - 1] < 0) {
//                dp[i] = nums[i];
//            } else {
//                dp[i] = dp[i - 1] + nums[i];
//            }
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
