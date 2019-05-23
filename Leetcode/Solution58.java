package LeetCode;

public class Solution58 {
    //最后一个单词的长度
    //给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
    //如果不存在最后一个单词，请返回 0 。
    public int lengthOfLastWord(String s) {
        char[] array = s.toCharArray();
        int count = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == ' ' && count == 0) {
                continue;
            }
            if (array[i] != ' ') {
                count++;
                continue;
            }
            if (array[i] == ' ' && count != 0) {
                return count;
            }
        }
        return count;
    }
}
