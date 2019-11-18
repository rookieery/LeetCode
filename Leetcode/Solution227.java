package LeetCode;

import java.util.Stack;

public class Solution227 {
    /**
     * 227. 基本计算器 II
     * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
     * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
     */
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                int[] r = getNum2(s, i);
                if (!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                    String sign = stack.pop();
                    int pre = Integer.parseInt(stack.pop());
                    int res = sign.equals("*") ? pre * r[0] : pre / r[0];
                    stack.push(res + "");//变成字符串
                } else {
                    stack.push(r[0] + "");
                }
                i = (int) r[1];//更新指针位置
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(') {
                stack.push(c + "");
            } else if (c == ')') {
                int result = 0;
                //括号里面只有+/-运算
                while (!stack.peek().equals("(")) {
                    int next = Integer.parseInt(stack.pop());
                    if (stack.isEmpty() || stack.peek().equals("(")) {
                        result += next;
                        break;
                    }
                    String sign = stack.pop();
                    result = sign.equals("+") ? result + next : result - next;
                }
                stack.pop();
                int res;
                //使得stack里面只有+/-运算符，保证算法优先级(原因：完成括号运算后的结果必然是一个数字)
                while (!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                    String sign = stack.pop();
                    int pre = Integer.parseInt(stack.pop());
                    res = sign.equals("*") ? pre * result : pre / result;
                    result = res;
                }
                stack.push(result + "");
            }
        }
        return getFinalResult(stack);
    }

    private int getFinalResult(Stack<String> stack) {
        int result = 0;
        while (!stack.isEmpty()) {
            int next = Integer.parseInt(stack.pop());
            if (stack.isEmpty()) {
                return result + next;
            }
            String sign = stack.pop();
            result = sign.equals("+") ? result + next : result - next;
        }
        return result;
    }

    private int[] getNum2(String s, int i) {
        int[] res = new int[2];
        int start = i;
        while (i < s.length() && (Character.isDigit(s.charAt(i)))) {
            i++;
        }
        res[0] = Integer.parseInt(s.substring(start, i));
        res[1] = i - 1;
        return res;
    }
}
