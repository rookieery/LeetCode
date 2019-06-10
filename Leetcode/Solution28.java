package LeetCode;

public class Solution28 {
    /**实现 strStr() 函数
     *给定一个 haystack 字符串和一个 needle 字符串，
     * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     */
    //中心扩展法
    public int strStr1(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (i + needle.length() <= haystack.length()) {
                    int a = 1;
                    while (a < needle.length() && needle.charAt(a) == haystack.charAt(i + a)) {
                        a++;
                    }
                    if (a == needle.length()) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
    //kmp算法
    public int strStr2(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        //int[] next = getNext2(needle);
        int[] next = getNexts(needle.toCharArray());
        int j = 0;
        int i = 0;
        while (i < haystack.length()) {
            if (j < 0 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return i - j;
                }
            } else if (next[j] == -1) {
                i++;
            } else {
                j = next[j];//返回其前缀字符
            }
        }
        return -1;
    }

    private int[] buildNext(char[] pattern) {
        int[] next = new int[pattern.length + 1];
        next[0] = -1;
        for (int i = 0; i < pattern.length; i++) {
            next[i + 1] = next[i] + 1;
            while (next[i + 1] > 0 && pattern[next[i + 1] - 1] != pattern[i]) {
                next[i + 1] = next[next[i + 1] - 1] + 1;
            }
        }
        return next;
    }

    private int[] getNext2(String P) {
        int[] next = new int[P.length()];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < P.length() - 1) {
            if (k == -1 || P.charAt(k) == P.charAt(j)) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];//aabaaac
            }
        }
        return next;
    }

    public int[] getNexts(char[] str2) {
        if (str2.length == 1) {
            return new int[]{-1};
        }
        int[] nexts = new int[str2.length];
        nexts[0] = -1;
        nexts[1] = 0;
        //指向当前元素最长前缀的指
        int cn = 0;
        //遍历字符串时的下标
        int index = 2;
        while (index < str2.length) {
            if (str2[index - 1] == str2[cn]) {
                nexts[index++] = ++cn;
            } else if (cn > 0) {
                cn = nexts[cn];
            } else {
                nexts[index++] = 0;
            }
        }
        return nexts;
    }
}
