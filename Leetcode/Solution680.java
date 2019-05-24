package LeetCode;

public class Solution680 {
    //验证回文串2
    //给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
    public boolean validPalindrome1(String s) {
        int a = 0;
        int b = s.length() - 1;
        int count = 0;
        while (a < b) {
            if (s.charAt(a) == s.charAt(b)) {
                a++;
                b--;
            } else if (s.charAt(a + 1) == s.charAt(b) && s.charAt(a) == s.charAt(b - 1) && count == 0) {
                int i = a + 1;
                int j = b - 1;
                int count1 = 0;
                int count2 = 0;
                count1 = getCount1(s, b, i, count1);
                count2 = getCount1(s, j, a, count2);
                return count1 != 1 || count2 != 1;
            } else if (s.charAt(a + 1) == s.charAt(b) && count == 0) {
                a = a + 2;
                b--;
                count++;
            } else if (s.charAt(a) == s.charAt(b - 1) && count == 0) {
                a++;
                b = b - 2;
                count++;
            } else {
                return false;
            }
        }
        return true;
    }

    private int getCount1(String s, int b, int i, int count1) {
        while (i < b) {
            if (s.charAt(i) == s.charAt(b)) {
                i++;
                b--;
            } else {
                count1 = 1;
                break;
            }
        }
        return count1;
    }

    public boolean validPalindrome2(String s) {
        return validPalindrome(s, 0, 0, s.length() - 1);
    }

    private boolean validPalindrome(String s, int k, int i, int j) {
        if (k > 1) return false;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return validPalindrome(s, k + 1, i + 1, j) || validPalindrome(s, k + 1, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }
}
