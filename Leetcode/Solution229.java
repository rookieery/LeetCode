package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution229 {
    //求众数2
    //给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int count = 1;
        int i = 0;
        while (i < nums.length-1) {
            int j = i + 1;
            if (nums[i] == nums[j]) {
                i++;
                count++;
            }
            else {
                if (count > nums.length/3) {
                    ans.add(nums[i]);
                    i++;
                    count = 1;
                }
                else {
                    i++;
                    count = 1;
                }
            }
        }
        if (nums.length == 1) {
            ans.add(nums[0]);
        }
        if (nums.length == 2) {
            ans.add(nums[1]);
        }
        if (nums.length > 2 && nums[nums.length-1] == nums[nums.length-2] && count > nums.length/3){
            ans.add(nums[nums.length-1]);
        }
        return ans;
    }
    //摩尔投票法
    public List<Integer> majorityElement3(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int num1 = 0;
        int num2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x == num1) {
                count1++;
            }
            else if (x == num2) {
                count2++;
            }
            else if (count1 == 0) {
                num1 = x;
                count1 = 1;
            }
            else if (count2 == 0) {
                num2 = x;
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x == num1) {
                count1++;
            }
            if (x == num2) {
                count2++;
            }
        }
        if (count1 > nums.length/3) {
            ans.add(num1);
        }
        if (count2 > nums.length/3) {
            ans.add(num2);
        }
        return ans;
    }
    public List<Integer> majorityElement2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] stack1 = new int[nums.length];
        int[] stack2 = new int[nums.length];
        int top1 = 0;
        int top2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (top1 == 0 || stack1[top1-1] == nums[i]) {
                stack1[top1] = nums[i];
                top1++;
            }
            else if ((top2 == 0 && nums[i] != stack1[top1-1]) || stack2[top2-1] == nums[i]) {
                stack2[top2] = nums[i];
                top2++;
            }
            else {
                top1--;
                top2--;
            }
        }
        ans.add(stack1[top1-1]);
        ans.add(stack2[top2-1]);
        return ans;//如果只有一个ans咋整
    }
}
