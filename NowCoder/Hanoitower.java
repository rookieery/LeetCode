package NowCoder;

public class Hanoitower {
    static int count = 0;
    public static void main(String[] args) {
        hanoiTower(20,'A','B','C');
        System.out.println(count);
    }

    //汉诺塔的移动方法
    //使用分治算法
    private static void hanoiTower(int num, char a, char b, char c) {
        count++;
        if (num == 1) {
            System.out.println("第1个盘从 " + a + "->" + c);
        } else {
            //先把最上面的所有盘A->B，移动过程中会使用到C
            hanoiTower(num - 1, a, c, b);
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            //把B塔的所有盘从B->C，移动过程使用到A
            hanoiTower(num - 1, b, a, c);
        }
    }
}
