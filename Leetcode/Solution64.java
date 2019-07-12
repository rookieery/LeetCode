package LeetCode;

public class Solution64 {
    /**
     * 64. 最小路径和
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * 说明：每次只能向下或者向右移动一步。
     */
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i + 1][j + 1] = grid[i][j] + dp[i + 1][j];
                } else if (j == 0) {
                    dp[i + 1][j + 1] = grid[i][j] + dp[i][j + 1];
                } else {
                    dp[i + 1][j + 1] = grid[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
