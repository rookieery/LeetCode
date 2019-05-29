package LeetCode;

public class Solution72 {
    //72.编辑距离
    //给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
    //你可以对一个单词进行如下三种操作：
    //插入一个字符
    //删除一个字符
    //替换一个字符
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        //dp[i][j] 代表最小操作数（步骤），从 word1[0..i-1]转化为 word2[0..j-1].
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for(int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[m][n];
    }
}
