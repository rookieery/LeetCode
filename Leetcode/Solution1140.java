package LeetCode;

public class Solution1140 {
    /**
     * 1140. 石子游戏 II
     * 亚历克斯和李继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。
     * 游戏以谁手中的石子最多来决出胜负。
     * 亚历克斯和李轮流进行，亚历克斯先开始。最初，M = 1。
     * 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。
     * 游戏一直持续到所有石子都被拿走。
     * 假设亚历克斯和李都发挥出最佳水平，返回亚历克斯可以得到的最大数量的石头。
     */
    //动态规划  dp[i][m] = Math.max(dp[i][m], sums[n] - sums[i] - dp[i + j][Math.max(m, j)]);
    public int stoneGameII1(int[] piles) {
        int n = piles.length;
        int[] sums = new int[n + 1];
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = piles[i] + sums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                int border = Math.min(2 * m, n - i);
                for (int j = 1; j <= border; j++) {
                    dp[i][m] = Math.max(dp[i][m], sums[n] - sums[i] - dp[i + j][Math.max(m, j)]);
                }
            }
        }
        return dp[0][1];
    }

    public int stoneGameII2(int[] piles) {
        int[] post_sum = new int[piles.length];
        // 记忆化防止重复搜索
        int[][] mem = new int[piles.length][piles.length];
        post_sum[piles.length - 1] = piles[piles.length - 1];
        // 后缀和
        for (int i = piles.length - 2; i >= 0; i--)
            post_sum[i] = post_sum[i + 1] + piles[i];
        return helper(piles, post_sum, mem, 0, 1);
    }

    public int helper(int[] piles, int[] sum, int[][] mem, int i, int M) {
        if (i >= piles.length)
            return 0;
        // 一把梭
        if ((i + 2 * M >= piles.length))
            return sum[i];
        if (mem[i][M] != 0)
            return mem[i][M];
        // 我想拿最多的，那就设法让对方拿到最少的
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= 2 * M; j++)
            min = Math.min(min, helper(piles, sum, mem, i + j, Math.max(M, j)));
        mem[i][M] = sum[i] - min;
        return sum[i] - min;
    }
}
