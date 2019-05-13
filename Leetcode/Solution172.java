package LeetCode;

public class Solution172 {
    //172.阶乘后的零
    //给定一个整数 n，返回 n! 结果尾数中零的数量。
    //说明: 你算法的时间复杂度应为 O(log n) 。
    public int trailingZeroes(int n) {
        int ans = 0;
        while(n != 0)
        {
            int t=n/5;
            ans+=t;
            n=t;
        }
        return ans;
    }
}
