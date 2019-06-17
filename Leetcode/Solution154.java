package LeetCode;

public class Solution154 {
    /**
     * 154. 寻找旋转排序数组中的最小值 II
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * 请找出其中最小的元素。
     * 注意数组中可能存在重复的元素。
     */
    public int findMin1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            while (left < right && nums[left] == nums[left + 1]) {
                left++;
            }
            while (right > left && nums[right] == nums[right - 1]) {
                right--;
            }
            int mid = (left + right) / 2;
            if (mid != right && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (mid != left && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[mid] > nums[left]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return nums[0];
    }

    public int findMin(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[0];
    }
}
