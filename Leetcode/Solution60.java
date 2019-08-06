package LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution60 {
    /**
     * 60. 第k个排列
     * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
     * 给定 n 和 k，返回第 k 个排列。
     */
    //回溯（超时）
    private List<String> list = new ArrayList<>();

    public String getPermutation(int n, int k) {
        int[] visited = new int[n];
        backtrack(n, new StringBuilder(), visited);
        list.sort(Comparator.comparingInt(Integer::valueOf));
        return list.get(k - 1);
    }

    private void backtrack(int n, StringBuilder sb, int[] visited) {
        if (sb.length() == n) {
            list.add(sb.toString());
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                sb.append(i + 1);
                backtrack(n, sb, visited);
                visited[i] = 0;
                sb.delete(sb.length() - 1, sb.length());
            }
        }
    }

    public String getPermutation2(int n, int k) {
        StringBuilder sb = new StringBuilder();
        // 候选数字
        List<Integer> candidates = new ArrayList<>();
        // 分母的阶乘数
        int[] factorials = new int[n+1];
        factorials[0] = 1;
        int fact = 1;
        for(int i = 1; i <= n; ++i) {
            candidates.add(i);
            fact *= i;
            factorials[i] = fact;
        }
        k -= 1;
        for(int i = n-1; i >= 0; --i) {
            // 计算候选数字的index
            int index = k / factorials[i];
            sb.append(candidates.remove(index));
            k -= index*factorials[i];
        }
        return sb.toString();
    }
}
