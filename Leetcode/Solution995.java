package LeetCode;

public class Solution995 {
    /**k连续位的最小翻转次数
     * 在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，
     * 同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。
     * 返回所需的 K 位翻转的次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。
     */
    public int minKBitFlips1(int[] A, int K) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                if (i + K > A.length) {
                    return -1;
                }
                for (int j = i; j < i + K; j++) {
                    A[j] ^= 1;
                }
                count ++;
            }
        }
        return count;
    }
    //优化
    public int minKBitFlips2(int[] A, int K) {
        int N = A.length;
        int[] hint = new int[N];
        int ans = 0, flip = 0;
        for (int i = 0; i < N; ++i) {
            flip ^= hint[i];//通过hint数组来及时改变flip的值，使得其满足下面的翻转条件
            if (A[i] == flip) {
                ans++;
                if (i + K > N) return -1;
                flip ^= 1;
                if (i + K < N) hint[i + K] ^= 1;
            }
        }

        return ans;
    }
}
