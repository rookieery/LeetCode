package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution216 {
    /**
     * 216. 组合总和 III
     * 找出所有相加之和为 n 的 k 个数的组合。
     * 组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     */
    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(n, new ArrayList<>(), k, 0, 0);
        return lists;
    }

    private void backtrack(int target, ArrayList<Integer> list, int length, int sum, int start) {
        if (list.size() > length) {
            return;
        }
        if (list.size() == length && sum == target) {
            lists.add(new ArrayList<>(list));
            return;
        }
        //由于i = start + 1，所以不必考虑节点是否被使用过的情况
        for (int i = start + 1; i <= 9; i++) {
            if (sum + i > target) {
                break;
            }
            sum += i;
            list.add(i);
            backtrack(target, list, length, sum, i);
            sum -= i;
            list.remove(list.size() - 1);
        }
    }
}
