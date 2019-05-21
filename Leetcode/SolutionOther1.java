package LeetCode;

import java.util.Arrays;

public class SolutionOther1 {
    //切蛋糕
    //有m块蛋糕，要分给n个顾客来吃，每块蛋糕大小不等，每个顾客的饭量也不同，并且蛋糕可分不可合。
    //给定蛋糕大小的集合cakes，给定顾客饭量的集合mouths，如何计算出这些蛋糕可以满足的最大顾客数量？
    //剩余蛋糕总量
    private static int leftCakes[];
    //蛋糕总量（不是数量，而是大小之和）
    private static int totalCake = 0;
    //浪费蛋糕量
    private static int lostCake = 0;

    private static boolean canFeed(int[] mouths, int mouthIndex, int sum) {
        if (mouthIndex <= 0) {
            //递归边界
            return true;
        }
        //如果蛋糕总量-浪费蛋糕量小于当前的需求量，直接返回false
        if (totalCake - lostCake < sum) {
            return false;
        }
        //从小到大遍历蛋糕
        for (int i = 0; i < leftCakes.length; i++) {
            if (leftCakes[i] >= mouths[mouthIndex]) {
                //找到并吃掉匹配的蛋糕
                leftCakes[i] -= mouths[mouthIndex];
                //剩余蛋糕小于最小需求，变成浪费蛋糕
                if (leftCakes[i] < mouths[1]) {
                    lostCake += leftCakes[i];
                }
                //继续递归，试图满足mid下标之前的需求
                if (canFeed(mouths, mouthIndex - 1, sum)) {
                    return true;
                }
                //无法满足需求，蛋糕状态回滚
                if (leftCakes[i] < mouths[1]) {
                    lostCake -= leftCakes[i];
                }
                leftCakes[i] += mouths[mouthIndex];
            }
        }
        return false;
    }

    public static int findMaxFeed(int[] cakes, int[] mouths) {
        //蛋糕升序排列，并把0下标空出
        int[] cakesTemp = Arrays.copyOf(cakes, cakes.length + 1);
        Arrays.sort(cakesTemp);
        for (int cake : cakesTemp) {
            totalCake += cake;
        }
        //顾客胃口升序排列，并把0下标空出
        int[] mouthsTemp = Arrays.copyOf(mouths, mouths.length + 1);
        Arrays.sort(mouthsTemp);
        leftCakes = new int[cakes.length + 1];
        //需求之和
        int[] sum = new int[mouths.length + 1];
        for (int i = 1; i <= mouths.length; i++) {
            sum[i] = sum[i - 1] + mouthsTemp[i];
        }
        //left和right用于计算二分查找的“中点”
        int left = 1;
        int right = mouths.length;
        //如果胃口总量大于蛋糕总量，right指针左移
        while (sum[right] > totalCake) {
            right--;
        }
        //中位指针，用于做二分查找
        int mid = ((left + right) >> 1);
        while (left <= right) {
            //重置剩余蛋糕数组
            leftCakes = Arrays.copyOf(cakesTemp, cakesTemp.length);
            //重置浪费蛋糕量
            lostCake = 0;
            //递归寻找满足需求的临界点
            if (canFeed(mouthsTemp, mid, sum[mid])) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = ((left + right) >> 1);
        }
        //最终找到的是刚好满足的临界点
        return mid;
    }
}
