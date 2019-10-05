package NowCoder;

import java.util.Arrays;

public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "abdjk aJB acbin acdacbiu";
        String str2 = "acdac";
        KMP kmp = new KMP(str2);
        System.out.println(kmp.search(str1));
        System.out.println(kmpSearch(str1,str2,kmpNext(str2)));
    }

    public static int kmpSearch(String s1, String s2, int[] next) {
        int index = 0;
        for (int i = 0; i < s1.length(); i++) {
            //KMP核心算法
            while (index > 0 && s1.charAt(i) != s2.charAt(index)) {
                index = next[index - 1];
            }
            if (s1.charAt(i) == s2.charAt(index)) {
                index++;
            }
            if (index == s2.length()) {
                return i - index + 1;
            }
        }
        return -1;
    }

    //获取next数组
    private static int[] kmpNext(String target) {
        int[] next = new int[target.length()];
        int index = 0;
        for (int i = 1; i < target.length(); i++) {
            //核心代码
            while (index > 0 && target.charAt(i) != target.charAt(index)) {
                index = next[index - 1];
            }
            if (target.charAt(i) == target.charAt(index)) {
                index++;
            }
            next[i] = index;
        }
        return next;
    }
}
