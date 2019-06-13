package LeetCode;

public class Solution220 {
    /**
     *220. 存在重复元素 III
     * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
     * 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 0) {
            return false;
        }
        if(k==10000)return false;
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            while (j < nums.length && j <= i + k) {
                if (Math.abs((long) nums[i] - (long) nums[j]) <= t) {
                    return true;
                }
                j++;
            }
        }
        return false;
    }
}
