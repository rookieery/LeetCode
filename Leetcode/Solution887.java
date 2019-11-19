package LeetCode;

import java.util.Arrays;

public class Solution887 {
    /**
     * 887. 鸡蛋掉落
     * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
     * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
     * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
     * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
     * 你的目标是确切地知道 F 的值是多少。
     * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
     */
    //方法一：暴力递归 tmp = Math.max(function(k - 1, i - 1), function(k, n - i));
    public int superEggDrop1(int K, int N) {
        return function(K, N);
    }

    private int function(int k, int n) {
        if (k == 1 || n == 1 || n == 0) {
            return n;
        }
        int min = n;
        for (int i = 1; i <= n; i++) {
            int tmp = Math.max(function(k - 1, i - 1), function(k, n - i));
            min = Math.min(min, tmp + 1);
        }
        return min;
    }

    //方法二（优化）：空间换时间
    public int superEggDrop2(int K, int N) {
        int[][] middleResults = new int[K + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            middleResults[1][i] = i; // only one egg
            middleResults[0][i] = 0; // no egg
        }
        for (int i = 1; i <= K; i++) {
            middleResults[i][0] = 0; // zero floor
        }

        for (int k = 2; k <= K; k++) { // start from two egg
            for (int n = 1; n <= N; n++) {
                int tMinDrop = N * N;
                for (int x = 1; x <= n; x++) {
                    tMinDrop = Math.min(tMinDrop, 1 + Math.max(middleResults[k - 1][x - 1], middleResults[k][n - x]));
                }
                middleResults[k][n] = tMinDrop;
            }
        }
        return middleResults[K][N];
    }

    //方法三：动规 dp[k][t] = dp[k-1][t-1] + dp[k][t-1] + 1（求k个鸡蛋在t步内可以测出多少）
    public int superEggDrop3(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int m = 1; m <= N; m++) {
            dp[0][m] = 0; // zero egg
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
                if (dp[k][m] >= N) {
                    System.out.println(Arrays.toString(dp[k]));
                    return m;
                }
            }
        }
        return N;
    }

    //方法四：数学法
    public int superEggDrop4(int K, int N) {
        int lo = 1, hi = N;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (f(mi, K, N) < N)
                lo = mi + 1;
            else
                hi = mi;
        }

        return lo;
    }

    public int f(int x, int K, int N) {
        int ans = 0, r = 1;
        for (int i = 1; i <= K; ++i) {
            r *= x - i + 1;
            r /= i;
            ans += r;
            if (ans >= N) break;
        }
        return ans;
    }
}
