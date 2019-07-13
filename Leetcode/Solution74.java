package LeetCode;

public class Solution74 {
    /**
     * 74. 搜索二维矩阵
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        int i = right < 0 ? 0 :right;
        int start = 0;
        int end = matrix[i].length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[i][mid] > target) {
                end = mid - 1;
            } else if (matrix[i][mid] < target) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
