package LeetCode;

public class Solution376 {
    /**
     * 376. 摆动序列
     * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。
     * 第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
     * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。
     * 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
     */
    //贪心
    public int wiggleMaxLength1(int[] nums) {
        if(nums.length==0) {
            return 0;
        }
        if(nums.length==1) {
            return 1;
        }
        int pretmp = nums[1]-nums[0];
        int count = pretmp!= 0 ? 2 : 1;
        for(int i=2;i<nums.length;i++) {
            int tmp = nums[i]-nums[i-1];
            if((tmp<0&&pretmp>=0)||(tmp>0&&pretmp<=0)){
                count++;
                pretmp=tmp;
            }
        }
        return count;
    }
    //动态规划
    public int wiggleMaxLength2(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int down = 1;
        int up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return Math.max(down, up);
    }
}
