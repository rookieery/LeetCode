package LeetCode;

import java.util.Arrays;

public class Solution215 {
    /**
     * 215. 数组中的第K个最大元素
     * 在未排序的数组中找到第 k 个最大的元素。
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     */
    //快排
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //计数排序
    public int findKthLargest2(int[] nums, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int n = max - min;
        int[] bucket = new int[n + 1];
        //3,5,1,7,3,9
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i] - min;
            bucket[tmp]++;
        }
        for (int i = n; i >= 0; i--) {
            if (bucket[i] > 0)
                k -= bucket[i];
            if (k <= 0)
                return i + min;
        }
        return 0;
    }
}
