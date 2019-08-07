package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class Solution446 {
    /**
     * 446. 等差数列划分 II - 子序列
     * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
     * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
     * 如果满足以下条件，则称子数组(P, Q)为等差数组：
     * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
     * 函数要返回数组 A 中所有等差子序列的个数。
     */
    public static int numberOfArithmeticSlices(int[] A) {
        int a = A.length;
        if (a < 3) {
            return 0;
        }
        long[][] nums = new long[a][a];
        long[][] dp = new long[a][a];
        for (int i = 0; i < a; i++) {
            for (int j = i - 1; j >= 0; j--) {
                nums[i][j] = (long) A[i] - A[j];
            }
        }
        int count = 0;
        for (int i = 0; i < a; i++) {
            for (int j = i - 1; j >= 0; j--) {
                boolean flag = true;
                for (int k = 0; k <= j - 1; k++) {
                    if (nums[i][j] == nums[j][k]) {
                        if (dp[i][j] == 0) {
                            dp[i][j] = dp[j][k] + 1;
                        } else {
                            dp[i][j] += 1;
                        }
                        flag = false;
                    }
                }
                if (dp[i][j] >= 3) {
                    count += dp[i][j] - 2;
                }
                if (flag) {
                    dp[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < a; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return count;
    }

    public static int numberOfArithmeticSlices1(int[] A) {
        HashMap<Long, Integer>[] diffMaps = new HashMap[A.length];
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            HashMap<Long, Integer> diffMap = new HashMap();
            diffMaps[i] = diffMap;
            long num = A[i];
            for (int j = 0; j < i; j++) {
                long diff = num - A[j];
                int count = diffMaps[j].getOrDefault(diff, 0);
                diffMaps[i].put(diff, diffMaps[i].getOrDefault(diff, 0) + count + 1);
                res += count;
            }
        }
        return res;
    }
}
