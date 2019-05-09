package LeetCode;

public class Solution20 {
    //20.有效的括号
    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    //有效字符串需满足：
    //左括号必须用相同类型的右括号闭合。
    //左括号必须以正确的顺序闭合。
    public boolean isBracket(char ch) {
        if('(' == ch || ')' == ch || '{' == ch || '}' == ch
                || '[' == ch || ']' == ch) {
            return true;
        }
        return false;
    }
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!isBracket(s.charAt(i))) {
                continue;
            }
            else {
                if (s.charAt(i)=='(' || s.charAt(i)=='{'
                        || s.charAt(i)=='[') {
                    stack[top++] = s.charAt(i);
                }
                else {
                    if(top == 0) {//右括号多
                        System.out.println("右括号多");
                        return false;
                    }
                    char c = stack[top-1];
                    if ('(' == c && ')' == s.charAt(i) ||
                            '{' == c && '}' == s.charAt(i) ||
                            '[' == c && ']' == s.charAt(i)) {
                        --top;
                    }
                    else {
                        System.out.println("右括号次序匹配出错");
                        return false;
                    }
                }
            }
        }
        if (top > 0) {
            System.out.println("左括号比右括号多");
            return false;
        }
        System.out.println("左括号===右括号");
        return true;
    }
}
