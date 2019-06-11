package LeetCode;

public class Solution287 {
    /**
     * 287. 寻找重复数
     * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
     * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
     */
    public int findDuplicate1(int[] nums) {
        int[] arr = new int[nums.length];
        for (int num : nums) {
            arr[num]++;
            if (arr[num] == 2) {
                return num;
            }
        }
        return 0;
    }
    public int findDuplicate2(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast) {
                fast = 0;
                while (nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }
}
