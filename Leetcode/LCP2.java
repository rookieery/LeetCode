package LeetCode;

public class LCP2 {
    /**
     * LCP 2. 分式化简
     * 有一个同学在学习分式。他需要将一个连分数化成最简分数，你能帮助他吗？
     * 输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。
     * 返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。
     */
    public int[] fraction(int[] cont) {
        int[] nums = new int[2];
        nums[0] = 1;
        for (int i = cont.length - 1; i >= 0; i--) {
            //交换分子和分母，并且执行运算
            int tmp = nums[1];
            nums[1] = nums[0];
            nums[0] = cont[i] * nums[1] + tmp;
        }
        return nums;
    }
}
