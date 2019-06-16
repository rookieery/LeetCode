package LeetCode;

public class Solution5 {
    //5.最长回文字串
    //给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
    //中心扩展算法
    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //分两种情况解决了奇偶的问题
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            //通过start和end来保存最大len的两端
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
    //Manacher 算法
    public String longestPalindrome2(String s) {
        char[] ch = s.toCharArray();
        char[] ah = new char[2 * s.length() + 1];//回避了要讨论奇偶两种情形的弊端
        for (int i = 0; i < 2 * s.length(); i = i + 2) {
            ah[i] = '#';
            ah[i + 1] = ch[i / 2];
        }
        ah[2 * s.length()] = '#';
        int[] arr = Manacher1(ah);
        return s.substring((arr[1] - arr[0]) / 2, (arr[1] + arr[0]) / 2);
    }

    private int[] Manacher1(char[] t) {
        int[] arr = new int[2];
        int[] len = new int[t.length];//既用于计数还能参与遍历
        int ans = 0;
        for (int i = 0; i < len.length; i++) {
            len[i] = 1;
        }
        for (int i = 0; i < len.length; i++) {
            while ((i - len[i] >= 0) && (i + len[i] < len.length) && t[i - len[i]] == t[i + len[i]]) {
                len[i]++;
            }
            ans = Math.max(ans, len[i]);
        }
        arr[0] = ans - 1;
        int i = 0;
        while (len[i] != ans) {
            i++;
        }
        arr[1] = i;
        return arr;
    }
    private int[] Manacher2(char[] t) {
        int[] arr = new int[2];
        int[] len = new int[t.length];
        int ans = 0;
        //另外两个指针起到优化算法的作用
        int mx = 0;
        int po = 0;
        for (int i = 0; i < len.length; i++) {
            if (mx > i) {
                len[i] = Math.min(mx - i, len[2 * po - i]);//如果前一个位置所形成的的回文串长度很大，那么下一个位置必定继承其部分长度
            } else {
                len[i] = 1;
            }
            while ((i - len[i] >= 0) && (i + len[i] < len.length) && t[i - len[i]] == t[i + len[i]]) {
                len[i]++;
            }
            if (len[i] + i > mx) {
                mx = len[i] + i;
                po = i;
            }
            ans = Math.max(ans, len[i]);
        }
        arr[0] = ans - 1;
        int i = 0;
        while (len[i] != ans) {
            i++;
        }
        arr[1] = i;
        return arr;
    }
}
