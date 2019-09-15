package LeetCode;

public class Solution231 {
    /**
     *231. 2的幂
     * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
     */

    //128 2 4 8 16 ... 128
    //128 64 32 16... 2

    // 4  ...100
    // 3  ...011

    // 8  ...1000
    // 7  ...0111



    // n n-1 & | ^
    // 8^7 = 1111
    //& 8 & 7 = 0
    // n & n-1 == 0 true





    public boolean isPowerOfTwo1(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {//1 2
            n /= 2;
        }
        return n == 1;
    }

    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & n - 1) == 0;
    }

    //此方法会造成数值溢出而形成死循环，所以不能用乘法
    public boolean isPowerOfTwo3(int n) {
        if (n <= 0) {
            return false;
        }
        int tmp = 1;
        while (tmp <= n) {
            if (tmp == n) {
                return true;
            }
            tmp <<= 1;
        }
        return false;
    }
}
