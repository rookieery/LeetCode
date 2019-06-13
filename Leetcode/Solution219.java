package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution219 {
    /**
     * 219. 存在重复元素 II
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
     * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            while (j < nums.length && j <= i + k) {
                if (nums[i] == nums[j]) {
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    //[2147483647,-2147483648,2147483647,-2147483648]
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!list1.contains(nums[i] - min)) {
                list1.add(nums[i] - min);//nums[i] - min
                list2.add(i);
            }
            else {
                if (i - list2.get(nums[i] - min) <= k) {
                    return true;
                }
                list2.add(i);
            }
        }
//        int[] arr = new int[d + 1];
//        int[] arri = new int[d + 1];
//        for (int i = 0; i < nums.length; i++) {
//            arr[nums[i] - min]++;
//            if (arr[nums[i] - min] == 2) {
//                if (i - arri[nums[i] - min] <= k) {
//                    return true;
//                }
//                arr[nums[i] - min]--;
//            }
//            arri[nums[i] - min] = i;
//        }
        return false;
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i],i);
            }
            else {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
                map.put(nums[i],i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {2147483647,-2147483648,2147483647,-2147483648};
        System.out.println(containsNearbyDuplicate2(nums,2));
    }
}
