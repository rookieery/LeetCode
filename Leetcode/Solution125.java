package LeetCode;

public class Solution125 {
    //125.验证回文串
    //给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    //说明：本题中，我们将空字符串定义为有效的回文串。
    public boolean isPalindrome(String s) {
        int a = 0;
        int b = s.length() - 1;
        while (a < b) {
            if ((s.charAt(a) >= 'a' && s.charAt(a) <= 'z') || (s.charAt(a) >= 'A' && s.charAt(a) <= 'Z')
                    || (s.charAt(a) >= '0' && s.charAt(a) <= '9')) {
                if ((s.charAt(b) >= 'a' && s.charAt(b) <= 'z') || (s.charAt(b) >= 'A' && s.charAt(b) <= 'Z')
                        || (s.charAt(b) >= '0' && s.charAt(b) <= '9')) {
                    if (s.charAt(a) == s.charAt(b)) {
                        a++;
                        b--;
                    }
                    else if (((s.charAt(a) >= 'a' && s.charAt(a) <= 'z') || (s.charAt(a) >= 'A' && s.charAt(a) <= 'Z'))
                            && ((s.charAt(b) >= 'a' && s.charAt(b) <= 'z') || (s.charAt(b) >= 'A' && s.charAt(b) <= 'Z'))
                            && (s.charAt(a) - s.charAt(b) == 32 || s.charAt(b) - s.charAt(a) == 32)) {
                        a++;
                        b--;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    b--;
                }
            }
            else {
                a++;
            }
        }
        return true;
    }
}
