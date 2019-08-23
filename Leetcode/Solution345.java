package LeetCode;

public class Solution345 {
    /**
     * 345. 反转字符串中的元音字母
     * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     */
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length()-1;
        char[] chars = s.toCharArray();
        while(i<=j) {
            char ch1 =chars[i];
            char ch2 =chars[j];
            if(ch1=='a'||ch1=='e'||ch1=='i'||ch1=='o'||ch1=='u'
                    ||ch1=='A'||ch1=='E'||ch1=='I'||ch1=='O'||ch1=='U') {
                if(ch2=='a'||ch2=='e'||ch2=='i'||ch2=='o'||ch2=='u'
                        ||ch2=='A'||ch2=='E'||ch2=='I'||ch2=='O'||ch2=='U') {
                    chars[i++] = ch2;
                    chars[j--] = ch1;
                } else {
                    j--;
                }
            } else {
                if(ch2=='a'||ch2=='e'||ch2=='i'||ch2=='o'||ch2=='u'
                        ||ch2=='A'||ch2=='E'||ch2=='I'||ch2=='O'||ch2=='U') {
                    i++;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return new String(chars);
    }
}
