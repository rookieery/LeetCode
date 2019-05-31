package LeetCode;

public class Solution415extend {
    /**
     * 字符串相减
     */
    public String subString(String num1,String num2) {
        StringBuilder sb = new StringBuilder();
        int amd = 0;
        int count = 0;//用于处理借位
        int a = num1.length() - 1;
        int b = num2.length() - 1;
        while (a >= 0) {
            int tmp = num1.charAt(a--) - '0' - count;
            if (b == -1) {
                amd = 0;
            }
            if (b >= 0) {
                amd = num2.charAt(b--) - '0';
            }
            if (tmp < amd) {
                sb.append(tmp - amd + 10);
                count = 1;
            }
            else {
                sb.append(tmp - amd);
                count = 0;
            }
        }
        int i = sb.length() - 1;
        while (i > 0 && sb.charAt(i) == '0') {//记录多余的字符'0'
            i--;
        }
        return sb.reverse().toString().substring(sb.length() - i - 1);
    }
}
