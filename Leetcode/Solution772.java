package LeetCode;

import java.util.Stack;

public class Solution772 {
    /**
     *772. 基本计算器 III
     *实现一个基本的计算器来计算一个简单的字符串表达式的值。
     * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和括号()。整数除法仅保留整数部分。
     */
    /**
     * 算法优先级：
     * 1.* /
     * 2.()
     * 3.+ -
     * 4.最终运算
     */
    private static double calculate(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                double[] r = getNum2(s, i);
                if (!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                    String sign = stack.pop();
                    double pre = Double.parseDouble(stack.pop());
                    double res = sign.equals("*") ? pre * r[0] : pre / r[0];
                    stack.push(res + "");//变成字符串
                } else {
                    stack.push(r[0] + "");
                }
                i = (int) r[1];//更新指针位置
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(') {
                stack.push(c + "");
            } else if (c == ')') {
                double result = 0;
                //括号里面只有+/-运算
                while (!stack.peek().equals("(")) {
                    double next = Double.parseDouble(stack.pop());
                    if (stack.isEmpty() || stack.peek().equals("(")) {
                        result += next;
                        break;
                    }
                    String sign = stack.pop();
                    result = sign.equals("+") ? result + next : result - next;
                }
                stack.pop();
                double res;
                //使得stack里面只有+/-运算符，保证算法优先级(原因：完成括号运算后的结果必然是一个数字)
                while (!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                    String sign = stack.pop();
                    double pre = Double.parseDouble(stack.pop());
                    res = sign.equals("*") ? pre * result : pre / result;
                    result = res;
                }
                stack.push(result + "");
            }
        }
        return getFinalResult(stack);
    }

    private static double getFinalResult(Stack<String> stack) {
        double result = 0;
        while (!stack.isEmpty()) {
            double next = Double.parseDouble(stack.pop());
            if (stack.isEmpty()) {
                return result + next;
            }
            String sign = stack.pop();
            result = sign.equals("+") ? result + next : result - next;
        }
        return result;
    }

    private static int[] getNum1(String s, int i) {
        int[] res = new int[2];
        //考虑多位数
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            res[0] = res[0] * 10 + s.charAt(i++) - '0';
        }
        //记录改变后的位置
        res[1] = i - 1;
        return res;
    }

    private static double[] getNum2(String s, int i) {
        double[] res = new double[2];
        int start = i;
        boolean flag = false;
        while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')) {
            if (s.charAt(i) == '.') {
                flag = true;
            }
            i++;
        }
        res[0] = flag ? Double.parseDouble(s.substring(start, i)) : Integer.parseInt(s.substring(start, i));
        res[1] = i - 1;
        return res;
    }
}
