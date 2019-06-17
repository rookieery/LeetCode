package LeetCode;

import java.util.LinkedList;

public class Solution239 {
    /**
     * 239. 滑动窗口最大值
     * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
     * 返回滑动窗口最大值。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k || nums.length == 0) {
            return nums;
        }
        int[] arr = new int[nums.length - k + 1];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                arr[i] = findMax(nums, i, i + k);
                continue;
            }
            if (arr[i - 1] == nums[i - 1]) {
                if (nums[i] >= arr[i - 1]) {
                    arr[i] = nums[i];
                } else {
                    arr[i] = findMax(nums, i, i + k);
                }
            } else {
                arr[i] = findMax(nums, i, i + k);
            }
        }
        return arr;
    }

    private int findMax(int[] arr, int a, int b) {
        int tmp = arr[a];
        for (int i = a; i < b; i++) {
            tmp = Math.max(tmp, arr[i]);
        }
        return tmp;
    }

    //双向队列
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数按从大到小排序
        LinkedList<Integer> list = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小 弹出
            while (!list.isEmpty() && nums[list.peekLast()] <= nums[i]) {
                list.pollLast();
            }
            // 添加当前值对应的数组下标
            list.addLast(i);
            // 初始化窗口 等到窗口长度为k时 下次移动在删除过期数值
            if (list.peek() <= i - k) {
                list.poll();
            }
            // 窗口长度为k时 再保存当前窗口中最大值
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[list.peek()];
            }
        }
        return result;
    }
}

