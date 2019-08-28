package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution228 {
    /**
     *228. 汇总区间
     * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }
        if (nums.length == 1) {
            list.add(String.valueOf(nums[0]));
            return list;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i == nums.length - 1) {
                if (nums[i] == nums[i - 1] + 1) {
                    list.add(nums[index] + "->" + (nums[i]));
                }
                if (nums[i] != nums[i - 1] + 1) {
                    if (index == i - 1) {
                        list.add(String.valueOf(nums[i - 1]));
                        list.add(String.valueOf(nums[i]));
                    } else {
                        list.add(nums[index] + "->" + (nums[i - 1]));
                        list.add(String.valueOf(nums[i]));
                    }
                }
                continue;
            }
            if (nums[i] != nums[i - 1] + 1) {
                if (index == i - 1) {
                    list.add(String.valueOf(nums[index]));
                } else {
                    list.add(nums[index] + "->" + (nums[i - 1]));
                }
                index = i;
            }
        }
        return list;
    }
}
