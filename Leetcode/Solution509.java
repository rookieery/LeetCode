package LeetCode;

public class Solution509 {
    /**
     * 509. 斐波那契数
     */
    //同Solution70
    public int fib(int N) {
        if(N == 0) {
            return 0;
        }
        int sum1 = 0;
        int sum2 = 1;
        for (int i = 1; i < N; i++) {
            int tmp = sum2;
            sum2 += sum1;
            sum1 = tmp;
        }
        return sum2;
    }
}
