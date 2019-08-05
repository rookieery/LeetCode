package LeetCode;

public class Solution434 {
    /**
     * 434. 字符串中的单词数
     * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
     * 请注意，你可以假定字符串里不包括任何不可打印的字符。
     */
    public int countSegments(String s) {
        int count = 0;
        boolean flag = false;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) !=' ') {
                if(!flag) {
                    count++;
                }
                flag = true;
            } else {
                flag = false;
            }
        }
        return count;
    }
}
