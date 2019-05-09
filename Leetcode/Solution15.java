package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    //15.三数之和
    //给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
    //注意：答案中不可以包含重复的三元组。
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//排序
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {  // 跳过重复的nums[i]
                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;// 跳过重复的nums[l]
                        while (l < r && nums[r] == nums[r - 1]) r--;// 跳过重复的nums[r]
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l + 1]) l++;// 跳过重复的nums[l]
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) r--;// 跳过重复的nums[r]
                        r--;
                    }
                }
            }
        }
        return ls;
    }
}
