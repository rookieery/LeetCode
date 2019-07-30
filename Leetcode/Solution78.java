package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    /**
     * 78. 子集
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * 说明：解集不能包含重复的子集。
     */
    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,new ArrayList<>(),0);
        return lists;
    }

    private void backtrack(int[] nums, ArrayList<Integer> list, int start) {
        lists.add(new ArrayList<>(list));
        if (list.size() == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
