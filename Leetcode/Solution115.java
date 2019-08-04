package LeetCode;

import java.util.Arrays;

public class Solution115 {
    /**
     * 115. 不同的子序列
     * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
     * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
     * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
     */
    //二维动规
    public int numDistinct1(String s, String t) {
        int a = s.length();
        int b = t.length();
        if(a==0||b==0) {
            return 0;
        }
        int[][] dp = new int[a+1][b+1];
        dp[0][0]=1;
        for(int i=0;i<a;i++) {
            dp[i+1][0] = 1;
            for(int j=0;j<b;j++) {
                if(s.charAt(i)==t.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j]+dp[i][j+1];
                } else {
                    dp[i+1][j+1] = dp[i][j+1];
                }
            }
        }
        return dp[a][b];
    }
    //一维动规
    public int numDistinct2(String s, String t) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,1);
        int pre = 1;
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j <= s.length(); j++) {
                int temp = dp[j];
                if(j == 0){
                    dp[j] = 0;
                }else {
                    if(t.charAt(i) == s.charAt(j-1)){
                        dp[j] = dp[j-1] + pre;
                    }else {
                        dp[j] = dp[j-1];
                    }
                }
                pre = temp;
            }
        }
        return dp[s.length()];
    }
    //逆序优化
    public int numDistinct3(String s, String t) {
        int[] dp = new int[t.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++){
            for (int j = t.length() - 1; j >= 0; j--) {
                if (t.charAt(j) == s.charAt(i)) {
                    dp[j + 1] += dp[j];
                }
            }
        }
        return dp[t.length()];
    }
    //花费空间字典降低时间复杂度
    public int numDistinct4(String s, String t) {
        // dp[0]表示空串
        int[] dp = new int[t.length() + 1];
        // dp[0]永远是1，因为不管S多长，都只能找到一个空串，与T相等
        dp[0] = 1;
        //t的字典
        int[] map = new int[128];
        Arrays.fill(map, -1);
        //这段代码的寻址就可以从map[s.charAt(i)] 找到索引j 在用next[j] 一直找和 s.charAt(i)相等的字符 其他的就可以跳过了
        //所以这个代码的优化 关键要理解 上面的一维倒算
        int[] nexts = new int[t.length()];
        for(int i = 0 ; i < t.length(); i++){
            int c = t.charAt(i);
            nexts[i] = map[c];
            map[c] = i;
        }

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            for(int j = map[c]; j >= 0; j = nexts[j]){
                dp[j + 1] += dp[j];
            }
        }
        return dp[t.length()];
    }
}
