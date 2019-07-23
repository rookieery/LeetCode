package NowCoder;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};//物品的重量
        int[] val = {1500, 3000, 2000};//物品的价值
        int m = 4;//背包的容量
        int n = val.length;//物品的个数
        int[][] dp = new int[n + 1][m + 1];
        //为了记录放入商品的情况，我们定义一个二维数组
        int[][] path = new int[n + 1][m + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (w[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - w[i - 1]]);
                    //为了记录商品的存放，不能直接使用状态转移方程
                    if (dp[i - 1][j] < val[i - 1] + dp[i - 1][j - w[i - 1]]) {
                        dp[i][j] = val[i - 1] + dp[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        System.out.println(dp[n][m]);
        //逆向打印路径
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.println("第" + (i) + "个商品放入背包");
                j -= w[i - 1];
            }
            i--;
        }
    }
}
