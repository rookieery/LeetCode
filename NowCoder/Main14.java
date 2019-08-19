package NowCoder;

import java.util.Scanner;

public class Main14 {
    /**
     * 坐标移动
     * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
     * 从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终 输入结果输出到输出文件里面。
     * 输入： 合法坐标为A(或者D或者W或者S) + 数字（两位以内） 坐标之间以;分隔。
     * 非法坐标点需要进行丢弃。如AA10; A1A; $%$; YAD; 等。
     */
    //异常解题法
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String string = sc.next();
            String[] strings = string.split(";");
            int[] arr = new int[2];
            for (String s : strings) {
                if (s.length()==0) {
                    continue;
                }
                if (s.charAt(0) == 'A') {
                    int a = 0;
                    try {
                        a = Integer.parseInt(s.substring(1));
                    } catch (Exception e) {
                        continue;
                    }
                    arr[1] -= a;
                } else if (s.charAt(0) == 'D') {
                    int d = 0;
                    try {
                        d = Integer.parseInt(s.substring(1));
                    } catch (Exception e) {
                        continue;
                    }
                    arr[1] += d;
                } else if (s.charAt(0) == 'W') {
                    int w = 0;
                    try {
                        w = Integer.parseInt(s.substring(1));
                    } catch (Exception e) {
                        continue;
                    }
                    arr[0] += w;
                } else if (s.charAt(0) == 'S') {
                    int x = 0;
                    try {
                        x = Integer.parseInt(s.substring(1));
                    } catch (Exception e) {
                        continue;
                    }
                    arr[0] -= x;
                }
            }
            System.out.println(arr[1] + "," + arr[0]);
        }
    }
}
