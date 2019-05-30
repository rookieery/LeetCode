package LeetCode;

public class Solution8 {
    /**
     * 8. 字符串转换整数 (atoi)
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，
     * 作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。
     * 如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     */
    public int myAtoi1(String str) {
        int i = 0, j = 0, len = str.length();
        boolean negative = false;
        for (i = 0; i < len; i++) {
            if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                break;
            } else if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                negative = str.charAt(i) == '-';
                i++;
                break;
            } else if (str.charAt(i) != ' ') {
                return 0;
            }
        }
        for (j = i; j < len; j++) {//只关注有效数字部分
            if (str.charAt(j) < '0' || '9' < str.charAt(j)) {
                break;
            }
        }
        int ret = 0;
        String num = str.substring(i, j);
        //判断数字越界
        for (int x = 0; x < num.length(); x++) {
            int cur = num.charAt(x) - '0';
            if (negative) {
                if (ret < Integer.MIN_VALUE / 10|| ret == Integer.MIN_VALUE / 10 && cur > 8) {
                    return Integer.MIN_VALUE;
                }
                ret = ret * 10 - cur;//巧妙
            } else {
                if (ret > Integer.MAX_VALUE / 10 || ret == Integer.MAX_VALUE / 10 && cur > 7) {
                    return Integer.MAX_VALUE;
                }
                ret = ret * 10 + cur;//巧妙
            }
        }
        return ret;
    }
    public int myAtoi2(String str) {
        int a = 0;
        while (a < str.length() && str.charAt(a) == ' ') {
            a++;
        }
        if (a == str.length()) {
            return 0;
        }
        if (str.charAt(a) == '+' || str.charAt(a) == '-' || (str.charAt(a) >= 48 && str.charAt(a) <= 57)) {
            if (str.charAt(a) == '+') {
                if (a == str.length() - 1 || !(str.charAt(a + 1) >= 48 && str.charAt(a + 1) <= 57)) {
                    return 0;
                }
                int b = a + 1;
                while (b < str.length() && str.charAt(b) >= 48 && str.charAt(b) <= 57 ) {
                    b++;
                }
                try {
                    return Integer.valueOf(str.substring(a,b));
                }catch (Exception e) {
                    return Integer.MAX_VALUE;
                }
            }
            else if (str.charAt(a) == '-') {
                if (a == str.length() - 1 || !(str.charAt(a + 1) >= 48 && str.charAt(a + 1) <= 57)) {
                    return 0;
                }
                int b = a + 1;
                while (b < str.length() && str.charAt(b) >= 48 && str.charAt(b) <= 57 ) {
                    b++;
                }
                try {
                    return Integer.valueOf(str.substring(a,b));
                }catch (Exception e) {
                    return Integer.MIN_VALUE;
                }
            }
            else {
                int b = a + 1;
                while (b < str.length() && str.charAt(b) >= 48 && str.charAt(b) <= 57 ) {
                    b++;
                }
                try {
                    return Integer.valueOf(str.substring(a,b));
                }catch (Exception e) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return 0;
    }
}
