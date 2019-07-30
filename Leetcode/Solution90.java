package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution90 {
    /**
     * 90. 子集 II
     * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * 说明：解集不能包含重复的子集。
     */
    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        backtrack(nums, new ArrayList<>(), 0, visited);
        return lists;
    }

    private void backtrack(int[] nums, ArrayList<Integer> list, int start, int[] visited) {
        lists.add(new ArrayList<>(list));
        if (list.size() == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (visited[i] == 0) {
                if (i > 0 && visited[i - 1] == 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                visited[i] = 1;
                list.add(nums[i]);
                backtrack(nums, list, i, visited);
                visited[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }
}
