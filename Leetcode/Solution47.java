package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 {
    /**
     * 47. 全排列 II
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     */
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
                if (i > 0 && visited[i - 1] == 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                visited[i] = 1;
                list.add(nums[i]);
                backtrack(nums, list, visited);
                visited[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }
}
