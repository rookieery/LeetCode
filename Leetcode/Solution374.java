package LeetCode;

public class Solution374 {
    /**
     * 374. 猜数字大小
     * 我们正在玩一个猜数字游戏。 游戏规则如下：
     * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
     * 每次你猜错了，我会告诉你这个数字是大了还是小了。
     * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
     */
    //二分查找
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while(left <= right) {
            int mid = (right-left)/2+left;
            int flag = guess(mid);
            if(flag == 1) {
                left = mid + 1;
            } else if(flag == -1) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int guess(int mid) {
        return 0;
    }
}
