package LeetCode;

public class Solution42 {
    //42.接雨水
    //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    public int trap(int[] height) {
        int count = 0;
        int leftmax = 0;
        int rightmax = function(height,0,height.length-1);
        for (int i = 0; i < height.length; i++) {
            leftmax = Math.max(leftmax,height[i]);
            if (rightmax == height[i]) {
                rightmax = function(height,i+1,height.length-1);
            }
            if (Math.min(leftmax,rightmax) - height[i] > 0) {
                count = count + Math.min(leftmax,rightmax) - height[i];
            }
        }
        return count;
    }
    public int function(int[] height,int start,int end) {
        int max = 0;
        for (int i = start; i <= end ; i++) {
            max = Math.max(max,height[i]);
        }
        return max;
    }
}
