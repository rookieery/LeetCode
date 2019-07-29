package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {
    /**
     * 39. 组合总和
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
     * 找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的数字可以无限制重复被选取。
     */
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>(), 0, 0);
        return lists;
    }

    private void backtrack(int[] nums, int target, ArrayList<Integer> list, int sum, int start) {
        if (sum == target) {
            lists.add(new ArrayList<>(list));//实现深拷贝
            return;
        }
        for (int i = start; i < nums.length; i++) {
            //sum + nums[i] > target作为循环终止的判断条件可以优化回溯深度
            if (sum + nums[i] > target) {
                break;
            }
            sum += nums[i];
            list.add(nums[i]);
            backtrack(nums, target, list, sum, i);
            sum -= nums[i];
            list.remove(list.size() - 1);
        }
    }
}
