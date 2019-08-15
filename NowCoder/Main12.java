package NowCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main12 {
    /**
     * 地下迷宫
     * 小青蛙有一天不小心落入了一个地下迷宫,小青蛙希望用自己仅剩的体力值P跳出这个地下迷宫
     * 。为了让问题简单,假设这是一个n*m的格子迷宫,迷宫每 个位置为0或者1,0代表这个位置有障碍物,
     * 小青蛙达到不了这个位置;1代表小青蛙可以达到的位置。
     * 小青蛙初始在(0,0)位置,地下迷宫的出口在(0,m-1)(保证这两个位置 都是1,并且保证一定有起点到终点可达的路径),
     * 小青蛙在迷宫中水平移动一个单位距离需要消耗1点体力值,向上爬一个单位距离需要消耗3个单位的体力值,向下移动 不消耗体力值,
     * 当小青蛙的体力值等于0的时候还没有到达出口,小青蛙将无法逃离迷宫。
     * 现在需要你帮助小青蛙计算出能否用仅剩的体力值跳出迷宫(即达到(0,m-1)位 置)。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int P = sc.nextInt();
            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            List<int[]> list = new ArrayList<>();
            boolean result = setWay(map, 0, 0, 0, P, list);
            if (result) {
                for (int[] num : list) {
                    if (num[0] == 0 && num[1] == m - 1) {
                        System.out.print("[" + 0 + "," + (m - 1) + "]");
                        break;
                    }
                    System.out.print("[" + num[0] + "," + num[1] + "]" + ",");
                }
            } else {
                System.out.println("Can not escape!");
            }
        }

    }

    private static boolean setWay(int[][] map, int i, int j, int sumP, int P, List<int[]> list) {
        if (sumP > P) {
            return false;
        }
        if (map[0][map[0].length - 1] == 2) {
            return true;
        }
        if (map[i][j] == 1) {
            map[i][j] = 2;
            list.add(new int[]{i, j});
            if (j + 1 < map[0].length && setWay(map, i, j + 1, sumP + 1, P, list)) {
                return true;
            } else if (i - 1 >= 0 && setWay(map, i - 1, j, sumP + 3, P, list)) {
                return true;
            } else if (i + 1 < map.length && setWay(map, i + 1, j, sumP, P, list)) {
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }
    }
}
