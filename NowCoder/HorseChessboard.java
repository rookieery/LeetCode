package NowCoder;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class HorseChessboard {
    private static int X;//棋盘的行数
    private static int Y;//棋盘的列数
    //创建一个数组，标记棋盘的各个位置算法被访问过
    private static boolean visited[];
    //使用一个属性，标记是否棋盘的所有位置都被访问
    private static boolean finished;

    public static void main(String[] args) {
        X = 8;
        Y = 8;
        int row = 6;
        int col = 6;
        int[][] chessboard = new int[X][Y];
        visited = new boolean[X * Y];
        long start = System.currentTimeMillis();
        traversalChessboard(chessboard, row - 1, col - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("共耗时" + (end - start) + "毫秒");
        for (int[] rows : chessboard) {
            for (int cols : rows) {
                System.out.print(cols + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 完成骑士周游问题的算法
     *
     * @param chessboard 棋盘
     * @param row        马儿当前的位置的行
     * @param col        马儿当前的位置的列
     * @param step       是第几步
     */
    private static void traversalChessboard(int[][] chessboard, int row, int col, int step) {
        chessboard[row][col] = step;
        visited[row * X + col] = true;//标记该位置已经访问
        //获取当前位置可以走的下一个位置的集合
        ArrayList<Point> ps = next(new Point(col, row));
        //贪心排序
        sort(ps);
        while (!ps.isEmpty()) {
            Point p = ps.remove(0);
            if (!visited[p.y * X + p.x]) {
                traversalChessboard(chessboard, p.y, p.x, step + 1);
            }
        }
        //判断马儿是否完成任务
        //step < X * Y 成立由两种情况
        //1.棋盘到目前位置仍然没有走完
        //2.棋盘处于一个回溯过程
        if (step < X * Y && !finished) {
            chessboard[row][col] = 0;
            visited[row * X + col] = false;
        } else {
            finished = true;
        }
    }

    /**
     * 功能：根据当前位置，计算出马儿还能走哪些位置，并放入到一个集合中（最多8个位置）
     *
     * @param curPoint
     * @return
     */
    private static ArrayList<Point> next(Point curPoint) {
        //创建一个ArrayList
        ArrayList<Point> ps = new ArrayList<>();
        //创建一个Point
        Point p1 = new Point();
        //表示马儿可走的最多8个位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    }

    //贪心优化：根据当前位置的所有下一步选择位置进行非递减排序
    private static void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return next(o1).size() - next(o2).size();
            }
        });
    }
}
