package LeetCode;

import java.util.*;

public class Solution491 {
    /**
     * 491. 递增子序列
     * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
     */
    private Set<List<Integer>> lists = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<Integer>(), 0);
        return new ArrayList<>(lists);
    }

    private void backtrack(int[] nums, ArrayList<Integer> list, int start) {
        if (list.size() >= 2) {
            lists.add(new ArrayList<>(list));
        }
        for (int i = start; i < nums.length; i++) {
            if (list.size() == 0 || nums[i] >= list.get(list.size() - 1)) {
                list.add(nums[i]);
                backtrack(nums, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
