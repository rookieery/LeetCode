package LeetCode;

public class Solution415 {
    /**
     * 415. 字符串相加
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     * 注意：
     * num1 和num2 的长度都小于 5100.
     * num1 和num2 都只包含数字 0-9.
     * num1 和num2 都不包含任何前导零。
     * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int tmp = 0;
        int a = num1.length() - 1;
        int b = num2.length() - 1;
        while (a >= 0 || b >= 0 || tmp != 0) {//此处的tmp != 0是处理类似80+20=100这种进位的情况发生
            if (a >= 0) {
                tmp += num1.charAt(a--) - '0';
            }
            if (b >= 0) {
                tmp += num2.charAt(b--) - '0';
            }
            sb.append(tmp % 10);//只拼接当前下标的一位数字，超出的位数的数字进给下一个下标进行处理
            tmp /= 10;
        }
        return sb.reverse().toString();
    }
}
