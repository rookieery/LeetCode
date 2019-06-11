package LeetCode;

public class Solution88 {
    /**
     * 88. 合并两个有序数组
     *给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     * 说明:
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0 ) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = nums2[i];
            }
        }
        else {
            int i = nums1.length - 1;
            while (i >= 0) {
                if (nums1[m - 1] > nums2[n - 1]) {
                    nums1[i] = nums1[m - 1];
                    i--;
                    m--;
                }
                else {
                    nums1[i] = nums2[n - 1];
                    i--;
                    n--;
                }
                if (m == 0 || n == 0) {
                    break;
                }
            }
            while (m != 0) {
                nums1[i] = nums1[m - 1];
                i--;
                m--;
            }
            while (n != 0) {
                nums1[i] = nums2[n - 1];
                i--;
                n--;
            }
        }
    }
}
