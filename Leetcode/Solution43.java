package LeetCode;

public class Solution43 {
    /**
     * 43. 字符串相乘
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * 说明：
     * num1 和 num2 的长度小于110。
     * num1 和 num2 只包含数字 0-9。
     * num1 和 num2 均不以零开头，除非是数字 0 本身。
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int a = num1.length() - 1;
        int b = num2.length() - 1;
        int[] arr = new int[num1.length() + num2.length()];//保存并操作数据的数组
        //两重循环把每一位数因进行的乘积都遍历到
        for (int i = a; i >= 0; i--) {
            int amd = num1.charAt(i) - '0';
            for (int j = b; j >= 0; j--) {
                int tmp = num2.charAt(j) - '0';
                arr[i + j] += amd * tmp;
                if (arr[i + j] >= 10 && (i + j) != 0) {
                    arr[i + j - 1] += arr[i + j] / 10;
                    arr[i + j] %= 10;
                }
            }
        }
        //arr[0]可以保存两位数字，正好把循环内部的0下标的缺陷弥补上
        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
