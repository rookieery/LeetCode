package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution131 {
    /**
     * 131. 分割回文串
     * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
     * 返回 s 所有可能的分割方案。
     */
    private List<List<String>> lists = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s,new ArrayList<>(),0);
        return lists;
    }

    private void backtrack(String s, ArrayList<String> list, int start) {
        if (start == s.length()) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (judge(s, start, i)) {
                list.add(s.substring(start, i + 1));
                backtrack(s, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean judge(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
