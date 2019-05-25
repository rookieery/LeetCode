package LeetCode;

public class Solution75 {
    //颜色分类
    //给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
    //此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
    public void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        int r = nums.length - 1;
        while (i <= r) {
            if (i < j || nums[i] == 1) {//i < j保证了如果起初前面元素都为0时，i也能与j同步
                i++;//保证了只有为1，i才会自增1
            }
            else if (nums[i] == 0) {
                swap(nums,i,j++);//保证1和0交换
            }
            else if (nums[i] == 2) {
                swap(nums,i,r--);//保证1和2交换
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
