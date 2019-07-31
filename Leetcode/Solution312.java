package LeetCode;

public class Solution312 {
    /**
     * 312. 戳气球
     * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
     * 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。
     *  这里的 left 和 right 代表和 i 相邻的两个气球的序号。
     * 注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
     * 求所能获得硬币的最大数量。
     * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
     * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
     */
    //动态规划 dp[i][j] = Math.max(dp[i][j], arr[i] * arr[k] * arr[j] + dp[i][k] + dp[k][j])
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        arr[0] = 1;
        System.arraycopy(nums, 0, arr, 1, arr.length - 1 - 1);
        arr[arr.length - 1] = 1;
        int[][] dp = new int[arr.length][arr.length];
        for (int len = 2; len < arr.length; len++) {
            for (int i = 0; i < arr.length - len; i++){
                int j = i + len;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], arr[i] * arr[k] * arr[j] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][arr.length - 1];
    }
}
