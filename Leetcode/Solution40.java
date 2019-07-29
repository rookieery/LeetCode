package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40 {
    /**
     * 40. 组合总和 II
     * 给定一个数组 candidates 和一个目标数 target ，
     * 找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的每个数字在每个组合中只能使用一次。
     */
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int[] visited = new int[candidates.length];
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>(), 0, 0, visited);
        return lists;
    }

    private void backtrack(int[] nums, int target, ArrayList<Integer> list, int sum, int start, int[] visited) {
        if (sum == target) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (sum + nums[i] > target) {
                break;
            }
            if (visited[i] == 0) {
                //去除掉因重复元素而产生的相同分支
                if (i > 0 && visited[i - 1] == 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                visited[i] = 1;
                sum += nums[i];
                list.add(nums[i]);
                backtrack(nums, target, list, sum, i, visited);
                visited[i] = 0;
                sum -= nums[i];
                list.remove(list.size() - 1);
            }
        }
    }
}
