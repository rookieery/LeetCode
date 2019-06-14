package LeetCode;

public class Solution402 {
    /**
     * 402. 移掉K位数字
     * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
     */
    //贪心算法
    public String removeKdigits1(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        StringBuilder str = new StringBuilder();
        str.append(num);
        int i = 0;
        while (i != str.length() - 1 && k != 0) {
            if (str.charAt(i) <= str.charAt(i + 1)) {
                i++;
            } else {
                str = str.delete(i, i + 1);
                k--;
                i = 0;
            }
        }
        String s = str.toString();
        if (k != 0) {
            s = str.substring(0, str.length() - k);
        }
        int count = 0;
        while (count != s.length() - 1 && s.charAt(count) == '0') {
            count++;
        }
        return s.substring(count);
    }
    //顺序栈
    public String removeKdigits2(String num, int k) {
        int newLength = num.length() - k;
        char[] stack = new char[num.length()];//顺序栈
        int top = 0;
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (top > 0 && stack[top - 1] > ch && k > 0) {//把所有比ch大的元素都出栈
                top --;
                k--;
            }
            stack[top++] = ch;
        }
        int count = 0;
        while (count < newLength && stack[count] == '0') {
            count++;
        }
        return count == newLength ? "0" : new String(stack,count,newLength - count);
    }
}
