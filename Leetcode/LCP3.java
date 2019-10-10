package LeetCode;

import java.util.Arrays;

public class LCP3 {
    /**
     * LCP 3. 机器人大冒险
     * 力扣团队买了一个可编程机器人，机器人初始位置在原点(0, 0)。
     * 小伙伴事先给机器人输入一串指令command，机器人就会无限循环这条指令的步骤进行移动。指令有两种：
     * U: 向y轴正方向移动一格.
     * R: 向x轴正方向移动一格。
     * 不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。
     * 给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。
     */
    //内存溢出
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int[][] arr = new int[x + 1][y + 1];
        for (int[] obstacle : obstacles) {
            int a = obstacle[0];
            int b = obstacle[1];
            if (a <= x && b <= y) {
                arr[a][b] = 1;
            }
        }
        char[] chs = new char[command.length()];
        for (int i = 0; i < command.length(); i++) {
            chs[i] = command.charAt(i);
        }
        System.out.println(Arrays.deepToString(arr));
        int i = 0;
        int j = 0;
        int index = 0;
        while (i <= x && j <= y) {
            if (arr[i][j] == 1) {
                return false;
            }
            if (i == x && j == y) {
                return true;
            }
            char tmp = chs[index++];
            if (tmp == 'U') {
                j++;
            } else {
                i++;
            }
            //这里循环会导致内存溢出
            if (index == chs.length) {
                index = 0;
            }
        }
        return false;
    }

    //根据R和U的数量判断某个点在不在路线上就好了
    //获取执行指令中UR的个数
    public int[] getDirectionCount(String command, int length) {
        int[] count = new int[]{0, 0};
        char[] charArr = command.toCharArray();
        for (int i = 0; i < length; i++) {
            if (charArr[i] == 'U') {
                count[0]++;
            } else {
                count[1]++;
            }
        }
        return count;
    }

    //方法如上，但是提交后，会涉及到内存溢出，原因是有的x+y非常大，导致command拼接的次数相当巨大，所以优化也在command拼接那里优化
    //优化后通过command的长度来获取移动指令中UR的次数
    public boolean getCount(int x, int y, String command) {
        int times = (x + y) / command.length();
        int extra = (x + y) % command.length();
        int[] yxStep = getDirectionCount(command, command.length());
        int[] yxStepEx = getDirectionCount(command, extra);
        yxStep[0] = yxStep[0] * times + yxStepEx[0];
        yxStep[1] = yxStep[1] * times + yxStepEx[1];
        return y == yxStep[0] && x == yxStep[1];
    }

    //补全：开始方法
    public boolean robot2(String command, int[][] obstacles, int x, int y) {
        for (int[] point : obstacles) {
            int pX = point[0];
            int pY = point[1];
            if (pX + pY > x + y) { //障碍点不在起终点的范围内
                continue;
            }
            if (getCount(pX, pY, command)) { //经过障碍点
                return false;
            }
        }
        return getCount(x, y, command);//经过终点
    }
}
