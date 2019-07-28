package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {
    /**
     * 46. 全排列
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     */
    //回溯
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int[] visited = new int[nums.length];
        backtrack(nums, new ArrayList<>(), visited);
        return lists;
    }

    private void backtrack(int[] nums, ArrayList<Integer> list, int[] visited) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                list.add(nums[i]);
                backtrack(nums, list, visited);
                visited[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }
}
