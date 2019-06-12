package LeetCode;

public class Solution81 {
    /**
     * 81. 搜索旋转排序数组 II
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
     * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
     */
    public boolean search1(int[] nums, int target) {
        return find(nums, 0, nums.length - 1, target);
    }

    private boolean find(int[] nums, int left, int right, int target) {
        if (left > right) {
            return false;
        }
        while (left < right && nums[left] == nums[left + 1]) {
            left++;
        }
        while (left < right && nums[right] == nums[right - 1]) {
            right--;
        }
        int mid = left + (right - left) / 2;
        if (target == nums[left]) {
            return true;
        }
        if (target == nums[right]) {
            return true;
        }
        if (target == nums[mid]) {
            return true;
        }
        if (target > nums[right] && target < nums[left]) {
            return false;
        }
        if (nums[mid] < nums[right]) {
            if (target > nums[mid] && target < nums[right]) {
                return binarySearch(nums, mid + 1, right - 1, target);
            } else {
                return find(nums, left, mid - 1, target);
            }
        } else {
            if (target > nums[left] && target < nums[mid]) {
                return binarySearch(nums, left + 1, mid - 1, target);
            } else {
                return find(nums, mid + 1, right, target);
            }
        }
    }

    private boolean binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean search2(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
