package LeetCode;

public class Solution9 {
    /**
     * 9. 回文数
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     */
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int i = 0;
        int j = s.length()-1;
        while(i<j) {
            if(s.charAt(i)==s.charAt(j)) {
                i++;
                j--;
            } else{
                return false;
            }
        }
        return true;
    }
}
