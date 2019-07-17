package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution407 {
    //接雨水2
    //给定一个 m x n 的矩阵，其中的值均为正整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
    class Node{
        int i;
        int j;
        int data;
        Node(int i,int j,int data){
            this.i = i;
            this.j = j;
            this.data = data;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        //重写compare方法是要干什么？？？
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.data - o2.data;
            }
        });
        if(heightMap.length < 3|| heightMap[0].length<3) return 0;
        int low = heightMap.length;
        int height = heightMap[0].length;
        int[][] visited = new int[low][height];
        //将这个数组中的边缘元素按照元素大小存入优先级队列中
        for(int i = 0;i < heightMap.length;i++) {
            for (int j = 0;j < heightMap[i].length;j++){
                if(i == 0 || j == 0 || i == heightMap.length-1 || j == heightMap[0].length-1){
                    Node node = new Node(i,j,heightMap[i][j]);
                    queue.add(node);
                    //将访问过的元素标记
                    visited[i][j] = 1;
                }
            }
        }
        //方向数组
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int result = 0;
        //由于是向内延伸，所以可以把整个数组都遍历完
        while(!queue.isEmpty()){
            int x = queue.peek().i;
            int y = queue.peek().j;
            int h = queue.peek().data;
            queue.poll();

            for(int i = 0;i < 4;i++) {
                int newX = x+dx[i];
                int newY = y+dy[i];
                //if条件保证了向内延伸
                if(newX < 0 || newX >= low ||
                        newY < 0 || newY >= height
                        || visited[newX][newY] == 1){
                    continue;
                }
                //一旦找到一个积水木，就把此积水木作为新的边缘
                //如何确定h-heightMap[newX][newY]就一定是当前的积水量？？？
                if(h > heightMap[newX][newY]){
                    result = result+h-heightMap[newX][newY];
                    heightMap[newX][newY] = h;
                }
                Node node = new Node(newX,newY,heightMap[newX][newY]);
                //遍历完一个积木 ，将它存入队列中
                queue.add(node);
                //标记
                visited[newX][newY] = 1;
            }
        }
        return result;
    }
}
