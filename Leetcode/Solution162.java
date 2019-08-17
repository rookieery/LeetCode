package LeetCode;

public class Solution162 {
    /**
     * 162. 寻找峰值
     * 峰值元素是指其值大于左右相邻值的元素。
     * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
     * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
     * 你可以假设 nums[-1] = nums[n] = -∞。
     */
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }
    //二分查找
    public int findPeakElement2(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = (right - left) / 2 + left;
        if (nums[mid] > nums[mid + 1]) {
            return binarySearch(nums, left, mid);
        }
        return binarySearch(nums, mid + 1, right);
    }
}
