package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Solution217 {
    /**
     * 217. 存在重复元素
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     */
    public boolean containsDuplicate1(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        int d = max - min;
        int[] arr = new int[d + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i] - min]++;
            if (arr[nums[i] - min] == 2) {
                return true;
            }
        }
        return false;
    }
    //Set底层是map实现，List实质就是暴力法
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> list = new HashSet<>();
        for (int num : nums) {
            if (list.contains(num)) {
                return true;
            }
            list.add(num);
        }
        return false;
    }
}
