package LeetCode;

public class Solution33 {
    /**
     * 33. 搜索旋转排序数组
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * 你可以假设数组中不存在重复的元素。
     * 你的算法时间复杂度必须是 O(log n) 级别。
     */
    //方法一：二分+递归
    public int search1(int[] nums, int target) {
        return find(nums, 0, nums.length - 1, target);
    }

    private int find(int[] nums, int left, int right, int target) {
        //递归的终止条件
        if (left > right) {
            return -1;
        }
        //判断边界条件
        int mid = left + (right - left) / 2;
        if (target == nums[left]) {
            return left;
        }
        if (target == nums[right]) {
            return right;
        }
        if (target == nums[mid]) {
            return mid;
        }
        if (target > nums[right] && target < nums[left]) {
            return -1;
        }
        //判断的核心代码
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

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //方法二：二分+二分
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int partition = findPartition(nums);
        if (partition != -1) {
            if (target == nums[partition]) {
                return partition;
            } else if (target > nums[nums.length - 1]) {
                return binarySearch(nums, 0, partition - 1, target);
            } else {
                return binarySearch(nums, partition + 1, nums.length - 1, target);
            }
        }
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int findPartition(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //此处是通过旋转点特殊的性质来得到旋转点
            if (mid != right && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid != left && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            if (nums[mid] < nums[left]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
