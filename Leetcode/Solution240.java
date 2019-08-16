package LeetCode;

public class Solution240 {
    /**
     * 240. 搜索二维矩阵 II
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     */
    //局部二分查找
    public boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0) {
            return false;
        }
        for(int i=0;i<matrix.length;i++) {
            int left=0;
            int right=matrix[i].length-1;
            while(left<=right) {
                int mid=left+(right-left)/2;
                if(matrix[i][mid]<target) {
                    left=mid+1;
                } else if(matrix[i][mid]>target) {
                    right=mid-1;
                } else{
                    return true;
                }
            }
        }
        return false;
    }
    //仿动态规划
    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0) {
            return false;
        }
        int i=0;
        int j=matrix[0].length-1;
        while(j>=0 && i<matrix.length) {
            if(matrix[i][j]>target) {
                j--;
            } else if(matrix[i][j]<target) {
                i++;
            } else{
                return true;
            }
        }
        return false;
    }
}
