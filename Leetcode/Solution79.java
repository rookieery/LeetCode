package LeetCode;

public class Solution79 {
    //79.单词搜索
    //给定一个二维网格和一个单词，找出该单词是否存在于网格中。
    //单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
    // 同一个单元格内的字母不允许被重复使用。
    private boolean flag = false;

    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    helper(board, visited, word, 0, i, j);
                    if (flag)
                        return true;//由于是在循环内部，如果满足条件可以返回true，但是不能提前返回false
                }
            }
        }
        return false;
    }

    private void helper(char[][] board, int[][] visited, String word, int index, int i, int j) {
        if (flag)
            return;
        //唯一一个能让flag变成true的条件
        if (index == word.length()) {
            flag = true;
            return;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        //类似于五子棋判断胜利的算法，以一个点为中心判断其周围能否形成单词，判断为这个点之后再重置回为0
        if (visited[i][j] == 0 && board[i][j] == word.charAt(index)) {
            visited[i][j] = 1;
            helper(board, visited, word, index + 1, i, j + 1);
            helper(board, visited, word, index + 1, i + 1, j);
            helper(board, visited, word, index + 1, i, j - 1);
            helper(board, visited, word, index + 1, i - 1, j);
            visited[i][j] = 0;
        }
    }
}
