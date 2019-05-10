package LeetCode;

public class Solution45 {
    //45.跳跃游戏2
    //给定一个非负整数数组，你最初位于数组的第一个位置。
    //数组中的每个元素代表你在该位置可以跳跃的最大长度。
    //你的目标是使用最少的跳跃次数到达数组的最后一个位置。
    public int jump(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        int reach = 0;
        int nextreach = nums[0];
        int step = 0;
        for(int i = 0;i<nums.length;i++){
            nextreach = Math.max(i+nums[i],nextreach);
            if(nextreach >= nums.length-1) return (step+1);
            if(i == reach){
                step++;
                reach = nextreach;
            }
        }
        return step;
    }
}
