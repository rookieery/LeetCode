package LeetCode;

public class Solution443 {
    /**
     * 443. 压缩字符串
     * 给定一组字符，使用原地算法将其压缩。
     * 压缩后的长度必须始终小于或等于原数组长度。
     * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
     * 在完成原地修改输入数组后，返回数组的新长度
     */
    public int compress(char[] chars) {
        int count = 1;
        int len = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1 && chars[i] == chars[i + 1]) {
                count++;
            }
            if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
                if (count == 1) {
                    chars[len++] = chars[i];
                }
                else {
                    chars[len++] = chars[i];
                    char[] ch = Integer.toString(count).toCharArray();//把一个数字变成数字字符形式
                    for (int j = 0; j < ch.length; j++) {
                        chars[len++] = ch[j];
                    }
                    count = 1;
                }
            }
        }
        return len;
    }
    //以字符串的形式进行操作
    public int compress1(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }
        String s = new String(chars);
        StringBuilder str = new StringBuilder();
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (i != s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
            }
            if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (count == 1) {
                    str.append(chars[i]);
                }
                else {
                    int tmp = count;
                    int b = 0;
                    while (tmp != 0) {
                        tmp /= 10;
                        b++;
                    }
                    str.append(chars[i]);
                    while (count != 0) {
                        int amd = count/(int) Math.pow(10,b - 1);
                        str.append(amd);
                        count -= amd;
                        b--;
                    }
                    count = 1;
                }
            }
        }
        return str.length();
    }
}
