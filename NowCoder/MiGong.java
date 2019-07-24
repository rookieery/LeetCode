package NowCoder;

public class MiGong {
    public static void main(String[] args) {
        //创建一个二维数组，模拟迷宫
        int[][] map = new int[8][7];
        //使用1表示墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板，1表示
        map[3][1] = 1;
        map[3][2] = 1;
        map[4][3] = 1;
        map[5][4] = 1;
        map[5][5] = 1;
        setWay(map, 1, 3);
        System.out.println("小球走过并标识过的地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //说明
    //1.map表示地图
    //2.i,j表示从地图的哪个位置开始出发
    //3.如果小球能够到map[6][5]，位置，则说明通路找到
    //4.约定：0表示该点没有走过，1表示墙，2表示通路可以走，3表示该点已经走过但是走不通
    //5.在走之前需要确定一个策略（方法）下，右，上，左，如果该点走不通，再回溯

    /**
     * @param map 表示地图
     * @param i   从哪个位置开始找
     * @param j
     * @return 如果找到通路，就返回true，否则返回false
     */
    private static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;//先假设此处可以通走
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;//发现此路不通，修改之前的判断值
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
