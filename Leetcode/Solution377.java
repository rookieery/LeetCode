package LeetCode;

import java.util.Arrays;

public class Solution377 {
    /**
     * 377. 组合总和 Ⅳ
     * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
     */
    //回溯（超时）
    private int count = 0;

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        backtrack(nums, target, 0);
        return count;
    }

    private void backtrack(int[] nums, int target, int sum) {
        if (sum == target) {
            count++;
            return;
        }
        for (int num : nums) {
            if (sum + num > target) {
                break;
            }
            sum += num;
            backtrack(nums, target, sum);
            sum -= num;
        }
    }
    //动态规划
    public int combinationSum41(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
