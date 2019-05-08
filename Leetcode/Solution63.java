package LeetCode;

public class Solution63 {
    //不同路径2
    //一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
    //机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
    //现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
    //网格中的障碍物和空位置分别用 1 和 0 来表示。
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        for(int i = 0; i<obstacleGrid.length;i++){
            for(int j = 0 ; j<obstacleGrid[i].length;j++){
                if(obstacleGrid[i][j] == 1){//操作障碍点（包括边缘的障碍点）
                    obstacleGrid[i][j] = 0;
                    continue;//很重要，使得一个点只会被判断进行一次操作
                }
                if(i==0 && j==0){//操作起点
                    obstacleGrid[i][j] = 1;
                    continue;
                }
                if(i==0 || j==0){//操作边缘点（如果遇到有障碍点，则后面的点都为0）
                    obstacleGrid[i][j] = i == 0?obstacleGrid[i][j-1]:obstacleGrid[i-1][j];
                    continue;
                }
                obstacleGrid[i][j] = obstacleGrid[i-1][j]+obstacleGrid[i][j-1];//操作正常点
            }
        }
        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
