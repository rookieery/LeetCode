package LeetCode;

public class Solution209 {
    /**
     * 209. 长度最小的子数组
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
     * 如果不存在符合条件的连续子数组，返回 0。
     */
    public int minSubArrayLen1(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            if (nums[0] >= s) {
                return 1;
            } else {
                return 0;
            }
        }
        int minLength = nums.length;
        int count = 1;
        int sum = nums[0];
        int i = 1;
        int j = 0;
        boolean flag = false;
        while (j != i) {
            if (sum >= s) {
                flag = true;
                minLength = Math.min(minLength,count);
                sum = sum - nums[j];
                j++;
                count--;
            }
            else {
                if (i == nums.length) {
                    break;
                }
                sum = sum + nums[i++];
                count++;
            }
        }
        if (flag) {
            return minLength;
        }
        return 0;
    }
    public int minSubArrayLen2(int s, int[] nums) {
        int sum = 0;
        int i = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        while (i < nums.length) {
            if (sum + nums[i] < s) {//先判断后加很巧妙
                sum = sum + nums[i];
                i++;
            } else {
                len = Math.min(len, i - start + 1);
                sum = sum - nums[start];
                start++;
                if (len == 1) {
                    break;
                }
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
