package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Solution523 {
    /**
     * 523. 连续的子数组和
     * 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，
     * 其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
     */
    //暴力法
    public boolean checkSubarraySum1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                sum += nums[j];
                if (k == 0 && sum == 0) {
                    return true;
                } else if (k != 0 && sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    //Map集合
    public boolean checkSubarraySum2(int[] nums, int k) {
        if (nums.length < 2) return false;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == 0 && nums[i + 1] == 0) {
                return true;
            }
        }
        if (k == 0) return false;
        if (k < 0) k = -k;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            int mod = sum % k;
            if (map.containsKey(mod)) {
                if (i - map.get(mod) > 1) {
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }
        return false;
    }
}
