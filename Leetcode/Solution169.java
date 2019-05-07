package LeetCode;

import java.util.Arrays;

public class Solution169 {
    //169.求众数
    //给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
    //你可以假设数组是非空的，并且给定的数组总是存在众数。
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    public int majorityElement2(int[] nums) {
        int[] stack = new int[nums.length];
        int a = 0;
        int top = 0;
        for (int i = 0; i < nums.length; i++) {
            if (top == 0 || stack[top-1] == nums[i]) {
                stack[top] = nums[i];
                top++;
            }
            else {
                top--;
            }
        }
        a = stack[top-1];
        return a;
    }
}
