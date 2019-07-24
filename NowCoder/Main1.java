package NowCoder;

import java.util.Scanner;

public class Main1 {
    /**
     *不要二
     * 二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。
     * 每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等 于2。
     * 对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
     * ( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根 小易想知道最多可以放多少块蛋糕在网格盒子里。
     */
    private static void code2() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int num;
        if (a%4==0||b%4==0) {
            num = a*b/2;
        } else {
            num =a*b/2+1;
        }
        System.out.println(num);
    }
    private static void code1() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a <= 2 && b <= 2) {
            System.out.println(a * b);
        } else if (a <= 2 || b <= 2) {
            if (a <= 2) {
                int c = b / 4;
                int d = b % 4;
                if (d <= 2) {
                    System.out.println(a * 2 * c + a * d);
                } else {
                    System.out.println(a * 2 * c + a * 2);
                }
            } else {
                int c = a / 4;
                int d = a % 4;
                if (d <= 2) {
                    System.out.println(b * 2 * c + b * d);
                } else {
                    System.out.println(b * 2 * c + b * 2);
                }
            }
        } else {
            int c = a * b;
            if (c % 2 == 0) {
                System.out.println(c / 2);
            } else {
                System.out.println((c + 1) / 2);
            }
        }
    }
}
