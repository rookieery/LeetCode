package LeetCode;

import java.util.*;

public class Solution128 {
    /**
     * 128. 最长连续序列
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
     * 要求算法的时间复杂度为 O(n)。
     */
    //计数排序  {2147483646, -2147483647, 0, 2, 2147483644, -2147483645, 2147483645}
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int d = max - min;
        int[] arr = new int[d + 1];
        for (int num : nums) {
            arr[num - min]++;
        }
        int count = 0;
        int maxLength = 0;
        for (int anArr : arr) {
            if (anArr == 0) {
                maxLength = Math.max(maxLength, count);
                count = 0;
            } else {
                count += anArr;
            }
        }
        return maxLength;
    }

    //排序
    public int longestConsecutive3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int longestStreak = 1;
        int currentStreak = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    currentStreak += 1;
                } else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }

        return Math.max(longestStreak, currentStreak);
    }

    //Set集合
    public int longestConsecutive1(int[] nums) {
        int maxLength = 0;
        Set<Integer> set = new HashSet<>();
        for (int num1 : nums) {
            set.add(num1);
        }
        for (int num : set) {
            //类似折半的思想，只考虑一半的情形，恰恰左端点便是最长值
            if (!set.contains(num - 1)) {
                int tmp = num;
                int count = 1;
                while (set.contains(tmp + 1)) {
                    tmp += 1;
                    count += 1;
                }
                maxLength = Math.max(maxLength, count);
            }
        }
        return maxLength;
    }

    //Map集合
    //put和contain都不需要时间复杂度？
    public int longestConsecutive2(int[] nums) {
        int maxLength = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, false);
        }
        for (int num : nums) {
            if (map.get(num)) {
                continue;
            }
            map.put(num, true);
            int left = num - 1;
            int right = num + 1;
            while (map.containsKey(left)) {
                map.put(left--, true);
            }
            while (map.containsKey(right)) {
                map.put(right++, true);
            }
            maxLength = Math.max(maxLength, right - left - 1);
        }
        return maxLength;
    }
}
