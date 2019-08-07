package LeetCode;

public class Solution673 {
    /**
     * 673. 最长递增子序列的个数
     * 给定一个未排序的整数数组，找到最长递增子序列的个数。
     */
    public int findNumberOfLIS(int[] nums) {
        int a = nums.length;
        if (a == 0) {
            return 0;
        }
        int[][] dp = new int[a][2];
        int maxLength = 0;
        int maxNum = 0;
        for (int i = 0; i < a; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i][0] < dp[j][0] + 1) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                    } else if (dp[i][0] == dp[j][0] + 1) {
                        dp[i][1] += dp[j][1];
                    }
                }
            }
            if (dp[i][0] == maxLength) {
                maxNum += dp[i][1];
            }
            if (dp[i][0] > maxLength) {
                maxLength = dp[i][0];
                maxNum = dp[i][1];
            }
        }
        return maxNum;
    }
}
