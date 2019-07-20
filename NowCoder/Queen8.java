package NowCoder;

import java.util.Queue;

public class Queen8 {
    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组array,保存皇后被放置位置的结果
    int[] array = new int[max];

    static int count = 0;

    static int judgeCount = 0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println("一共有"+(count)+"种解法");
        System.out.println("一共判断"+(judgeCount)+"次冲突");
    }

    //编写一个方法，放置第n个皇后
    //特别注意：check的每一层递归时都有一个for循环，进而产生了回溯
    private void check(int n) {
        if (n == max) {
            print();
            count++;
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }
    //检验该皇后是否和前面已经摆放的皇后发生冲突

    /**
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //一维数组，不可能在同一行
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //写一个方法，可以将皇后摆放的位置输出
    private void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
