package LeetCode;

public class Solution4 {
    //4.寻找两个有序数组的中位数
    //给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
    //请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
    //你可以假设 nums1 和 nums2 不会同时为空。
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length+nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i <= nums1.length-1 && j <= nums2.length-1) {
            if (nums1[i] <= nums2[j]) {
                array[k++] = nums1[i++];
            }
            else{
                array[k++] = nums2[j++];
            }
        }
        while (i <= nums1.length-1) {
            array[k++] = nums1[i++];
        }
        while (j <= nums2.length-1) {
            array[k++] = nums2[j++];
        }
        if (array.length%2 == 0) {
            return (array[array.length/2]+array[array.length/2-1])/2.0;
        }
        return (double)array[array.length/2];
    }
}
