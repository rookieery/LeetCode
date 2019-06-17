package LeetCode;

public class Solution34 {
    /**
     * 34.在排序数组中查找元素的第一个和最后一个位置
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * 如果数组中不存在目标值，返回 [-1, -1]。
     */
    //二分查找
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                left = mid - 1;
                while (left >= 0 && nums[left] == target) {
                    left--;
                }
                right = mid + 1;
                while (right < nums.length && nums[right] == target) {
                    right++;
                }
                arr[0] = left + 1;
                arr[1] = right - 1;
                return arr;
            }
        }
        arr[0] = -1;
        arr[1] = -1;
        return arr;
    }
}
