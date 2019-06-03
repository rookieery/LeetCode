package LeetCode;

public class Solution268 {
    //268.缺失数字
    //给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return (nums.length*(nums.length+1))/2-sum;
    }
    public int missingNumber1(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++){
            sum ^= nums[i];
            sum ^= i;
        }
        return sum;
    }
    public int missingNumber2(int[] nums) {
        int[] array = new int[nums.length+1];
        array[0] = 1;
        for (int j = 0; j < nums.length; j++) {
            array[nums[j]] = nums[j];
        }
        int j = 0;
        for ( j = 0; j < nums.length; j++) {
            if (array[j] != j) {
                break;
            }
        }
        return j;
    }
}
