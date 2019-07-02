package LeetCode;

public class Solution214 {
    //214.最短回文串
    //给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。
    // 找到并返回可以用这种方式转换的最短回文串。
    public String shortestPalindrome1(String s) {
        if (s.equals("") || s.length() == 1) {
            return s;
        }
        int x = getFrontS(s);
        return new StringBuilder(s.substring(x + 1)).reverse().toString() + s;
    }
    //获得原字符串的最长前缀回文字符串长度
    private int getFrontS(String s) {
        int a = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(a) == s.charAt(i)) {
                int b = i - 1;
                a++;
                while (a < b) {
                    if (s.charAt(a) == s.charAt(b)) {
                        a++;
                        b--;
                    }
                    else {
                        break;
                    }
                }
                if (a >= b) {
                    return i;
                }
                a = 0;
            }
        }
        return 0;
    }
    //KMP算法的next数组
    public String shortestPalindrome2(String s) {
        if (s.equals("") || s.length() == 1) {
            return s;
        }
        String temp = s + "#" + new StringBuilder(s).reverse().toString() + "#";//中间那个#是为了把两段字符串分隔开，避免产生干扰
        int[] next = getNext1(temp);
        int index = next[temp.length()-1];  //取得最长前缀回文字符串的下标
        return new StringBuilder(s.substring(index)).reverse().toString() + s;//为什么是把temp的得到下标用于给s进行截断
    }
    private int[] getNext1(String p) {
        int[] next = new int[p.length() + 1];
        next[0] = -1;
        for (int i = 0; i < p.length(); i++) {
            next[i + 1] = next[i] + 1;
            while (next[i + 1] > 0 && p.charAt(next[i + 1] - 1) != p.charAt(i)) {
                next[i + 1] = next[next[i + 1] - 1] + 1;
            }
        }
        return next;
    }

    private int [] getNext2(String P) {
        int [] next = new int[P.length()];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < P.length()-1) {
            if (k == -1 || P.charAt(k) == P.charAt(j)) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
