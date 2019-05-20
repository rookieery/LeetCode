package LeetCode;

public class Solution233 {
    //数字1的个数（拓展）
    //给定一个整数n，计算所有小于等于n的非负整数中数字a（0<=a<=9）出现的个数
    public int countDigitOne1(int n,int b) {
        if (n < b)
            return 0;
        int len = getLenOfNum(n);
        if (len == 1)
            return 1;
        int tmp = (int) Math.pow(10, len - 1);
        int first = n / tmp; // 获取n的最高位数字
        int firstOneNum = first ;
        if (firstOneNum > b) {
            firstOneNum = tmp;
        }
        else if (firstOneNum < b) {
            firstOneNum = 0;
        }
        else {
            firstOneNum = (n % tmp) + 1;
        }//获取最高位数出现数字b的次数
        int otherOneNUm = first * (len - 1) * (tmp / 10);//固定最高位数字，其它位数字中数字b出现的次数
        return firstOneNum + otherOneNUm + countDigitOne1(n % tmp,b);//通过递归实现每次都把最高位降1，然后进行累加
    }
    public int countDigitOne2(int n,int b) {
        if (n < b)
            return 0;
        int len = getLenOfNum(n);
        if (len == 1)
            return 1;
        int tmp = (int) Math.pow(10, len - 1);
        int sum;
        if ((n / tmp) > b) {
            sum = tmp;
        }
        else if ((n / tmp) < b) {
            sum = 0;
        }
        else {
            sum = n % tmp + 1;
        }//获取最高位数出现数字b的次数
        for (int i = len - 1; i > 0; i--) {
            int x = n / (int) Math.pow(10, i);// 获取最高位数字
            int z = n / (int) Math.pow(10, i - 1);
            int y = z % 10;//获取最高位的下一位数字
            if (y > b) {
                sum = sum + (x + 1)*((int) Math.pow(10, i - 1));
            }
            else if (y < b) {
                sum = sum + x * ((int) Math.pow(10, i - 1));
            }
            else {
                sum = sum + (x + 1)*((int) Math.pow(10, i - 1)) - ((z + 1)*((int) Math.pow(10, i - 1)) - n - 1);
            }
        }
        return sum;
    }
    public int getLenOfNum(int n) {
        int len = 0;
        while (n != 0) {
            len++;
            n /= 10;
        }
        return len;
    }//得到数字n的位数
}
