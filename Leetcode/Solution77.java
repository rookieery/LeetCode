package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution77 {
    /**
     * 77. 组合
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     */
    //回溯
    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combine1(int n, int k) {
        backtrack(n, k, new ArrayList<>(), 1);
        return lists;
    }

    private void backtrack(int n, int k, ArrayList<Integer> list, int start) {
        if (list.size() == k) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrack(n, k, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
    //二进制排序
    public List<List<Integer>> combine(int n, int k) {
        // init first combination
        LinkedList<Integer> nums = new LinkedList<Integer>();
        for(int i = 1; i < k + 1; ++i)
            nums.add(i);
        nums.add(n + 1);

        List<List<Integer>> output = new ArrayList<List<Integer>>();
        int j = 0;
        while (j < k) {
            // add current combination
            output.add(new LinkedList(nums.subList(0, k)));
            // increase first nums[j] by one
            // if nums[j] + 1 != nums[j + 1]
            j = 0;
            while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1))
                nums.set(j, j++ + 1);
            nums.set(j, nums.get(j) + 1);
        }
        return output;
    }
}
