package LeetCode;

public class Solution {
    /**
     * 414. 第三大的数
     * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。
     * 要求算法时间复杂度必须是O(n)。
     */
    public int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int nextMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                nextMax = Math.max(nextMax, nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max && nums[i] < nextMax) {
                thirdMax = Math.max(thirdMax, nums[i]);
                flag = true;
            }
        }
        return flag ? thirdMax : max;
    }

    public int thirdMax1(int[] nums) {
        long first=Long.MIN_VALUE,second=Long.MIN_VALUE,third=Long.MIN_VALUE;
        for(long num:nums){
            if(num>first){
                third=second;
                second=first;
                first=num;
            }else if(num>second&&num<first){
                third=second;
                second=num;
            }else if(num>third&&num<second){
                third=num;
            }
        }
        return (third==Long.MIN_VALUE||third==second)?(int)first:(int)third;
    }
}
