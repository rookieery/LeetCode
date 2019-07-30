package LeetCode;

public class Solution300 {
    /**
     * 300. 最长上升子序列
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     */
    //动态规划
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int maxLength = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] == 0) {
                dp[i] = 1;
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    //二分查找
    public static int lengthOfLIS1(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int[] arr = new int[len];
        int size = 0;
        arr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > arr[size]) {
                arr[++size] = nums[i];
            } else {
                int left = 0;
                int right = size;
                while (left < right) {
                    int mid = (right - left) / 2 + left;
                    if (arr[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                arr[right] = nums[i];
            }
        }
        return size + 1;
    }
}
