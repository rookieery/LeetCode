package LeetCode;

public class Solution80 {
    /**
     * 删除排序数组中的重复项2
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     */
    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int count = 1;
        int a = 0;
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i - 1];
            if (nums[i] == tmp && count != 2) {
                count++;
                nums[a++] = tmp;
                continue;
            }
            if (nums[i] != tmp) {
                nums[a++] = tmp;
                count = 1;
            }
        }
        if (count <= 2) {
            nums[a++] = nums[nums.length - 1];
        }
        return a;
    }
    public int removeDuplicates2(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count < 2 || nums[i] > nums[count - 2]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
