package LeetCode;

import java.util.*;

public class Solution522 {
    /**
     * 522. 最长特殊序列 II
     * 给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：
     * 该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
     * 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
     * 输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。
     */
    public static int findLUSlength(String[] strs) {
        //(1)去重
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            map.put(strs[i], map.get(strs[i]) == null ? 1 : (map.get(strs[i]) + 1));//?
        }
        //(2)分组:A中不含重复的;B中含有去重之后的重复的
        List<String> listA = new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        List<String> listB = new ArrayList<>();
        for (String str : map.keySet()) {
            if (map.get(str) == 1) {
                listA.add(str);
                listB.add(str);
            } else {
                listB.add(str);
            }
        }
        //(3)按长度排序
        listA.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        listB.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        //(4)查找
        for (int i = listA.size() - 1; i >= 0; i--) {
            if (!isSubsequence(listA.get(i),listB)) {
                return listA.get(i).length();
            }
        }
        return -1;
    }
    public static boolean isSubsequence(String str, List<String> strs) {
        int indexA = 0;
        int indexB = 0;
        for(int i=strs.size()-1;i>=0;i--){
            if(strs.get(i).length()<str.length()){
                return false;
            }
            if(strs.get(i).equals(str)){
                continue;
            }
            indexA = 0;
            indexB = 0;
            //判断是不是子序列
            while(indexA<str.length()&&indexB<strs.get(i).length()){
                if(str.charAt(indexA)==strs.get(i).charAt(indexB)){
                    indexA ++;
                    indexB ++;
                }else {
                    indexB ++;
                }
            }
            if(indexA==str.length()){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] arg) {
        String[] strs = {"aabbcc","aabbcc","c","e"};
        System.out.println(findLUSlength(strs));
    }
}
