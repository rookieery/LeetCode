package LeetCode;

public class Solution326 {
    /**
     * 326. 3的幂
     * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
     */
    //除法
    public boolean isPowerOfThree1(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
    //整形最大3的幂
    public boolean isPowerOfThree2(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
