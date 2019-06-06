package LeetCode;

public class Solution31 {
    /**
     *下一个排列
     *实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     * 必须原地修改，只允许使用额外常数空间
     */
    /**
     * 其实就是从数组倒着查找，找到nums[i] 比nums[i+1]小的时候，
     * 就将nums[i]跟nums[i+1]到nums[nums.length - 1]当中找到一个最小的比nums[i]大的元素交换。
     * 交换后直接倒序交换就可以了
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0) {
            if (nums[i - 1] >= nums[i]) {
                i--;
            } else {
                break;
            }
        }
        if (i == 0) {
            for (int j = 0; j < nums.length / 2; j++) {
                int tmp = nums[j];
                nums[j] = nums[nums.length - 1 - j];
                nums[nums.length - 1 - j] = tmp;
            }
        } else {
            i--;
            int a = nums.length - 1;
            while (nums[i] >= nums[a]) {
                a--;
            }
            int tmp = nums[i];
            nums[i] = nums[a];
            nums[a] = tmp;
            int t = 0;
            for (int j = i + 1; j <= (nums.length - i)/2 + i; j++) {
                int amp = nums[j];
                nums[j] = nums[nums.length - 1 - t];
                nums[nums.length - 1 - t] = amp;
                t++;
            }
        }
    }
}
