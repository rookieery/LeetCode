package LeetCode;

public class Solution605 {
    /**
     * 605. 种花问题
     * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。
     * 可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。
     * 能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
     */
    //方法一：贪心
    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }

    //方法二：前后补0，处理边界
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int num = 0, count = 1;  //假设在数组左边添加0，以解决边界问题，令count初始为1
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                count++;
            } else {
                count = 0;
            }
            if (count == 3) {    //每连续三个0种一次花
                num++;
                count = 1;
            }
        }
        if (count == 2) {    //如果最后count为2而不是1，表示最后一个位置可以种花
            num++;
        }
        return n <= num;
    }
}
