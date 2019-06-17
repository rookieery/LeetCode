package LeetCode;

public class Solution50 {
    /**
     * 50. Pow(x, n)
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
     */
    public double myPow2(double x, int n) {
        double res = 1.0;
        for(int i = n; i != 0; i /= 2){
            if(i % 2 != 0){
                res *= x;
            }
            x *= x;
        }
        return  n < 0 ? 1 / res : res;
    }
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        if (n > 0) {
            return fastPow(x, n);
        }
        n = -n;
        return 1.0 / fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    public double myPow1(double x, int n) {
        double mul = 1;
        if (n == 0 || x == 1) {
            return 1;
        }
        if (n > 0) {
            return pow(x, n, mul);
        }
        n = -n;
        return 1.0 / pow(x, n, mul);
    }

    private double pow(double x, int n, double mul) {
        if (n == 1) {
            return mul * x;
        }
        if (n % 2 == 0) {
            x *= x;
            n /= 2;
            return pow(x, n, mul);
        } else {
            n /= 2;
            mul = x * pow(x, n, mul);
            return pow(x,n,mul);
        }
    }
}
