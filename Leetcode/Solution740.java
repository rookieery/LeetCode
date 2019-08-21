package LeetCode;

public class Solution740 {
    /**
     * 740. 删除与获得点数
     * 给定一个整数数组 nums ，你可以对它进行一些操作。
     * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。
     * 之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
     * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
     */
    public int deleteAndEarn(int[] nums) {
        int[] sum = new int[10001];
        for (int num : nums) {
            sum[num] += num;
        }
        int[] dp = new int[10001];
        dp[1] = sum[1];
        for (int i = 2; i < sum.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum[i]);
        }
        return dp[10000];
    }

    public int deleteAndEarn2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int max = nums[0];
        for (int i = 0; i < len; ++i) {
            max = Math.max(max, nums[i]);
        }
        int[] all = new int[max + 1];
        for (int item : nums) {
            all[item] ++;
        }
        int[] dp = new int[max + 1];
        dp[1] = all[1];
        for (int i = 2; i <= max; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);
        }
        return dp[max];
    }
}
