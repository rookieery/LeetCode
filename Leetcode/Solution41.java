package LeetCode;

public class Solution41 {
    //41.缺失的第一个正数
    //给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
    //你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
    public int firstMissingPositive(int[] nums) {
        int[] array = new int[nums.length];
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] >= 1 && nums[j] <= nums.length) {
                array[nums[j]-1] = nums[j];//让新的array数组形成了以下标+1为基准的排序
            }
        }
        int j = 0;
        for ( j = 0; j < nums.length; j++) {
            if (array[j] != j+1) {
                break;
            }
        }
        return j+1;
    }
}
