package LeetCode;

public class Solution153 {
    /**
     * 153. 寻找旋转排序数组中的最小值
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * 请找出其中最小的元素。
     * 你可以假设数组中不存在重复元素。
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            //两终止if条件正好互补
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
}
