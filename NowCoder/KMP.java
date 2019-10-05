package NowCoder;

public class KMP {
    private int[][] dp;
    private String pat;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        dp = new int[M][256];
        dp[0][pat.charAt(0)] = 1;
        int X = 0;
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < 256; j++) {
                if (pat.charAt(i) == j) {
                    dp[i][j] = i + 1;
                } else {
                    dp[i][j] = dp[X][j];
                }
            }
            X = dp[X][pat.charAt(i)];
        }
    }

    public int search(String txt) {
        int M = pat.length();
        int N = txt.length();
        int j = 0;
        for (int i = 0; i < N; i++) {
            j = dp[j][txt.charAt(i)];
            if (j == M) {
                return i - M + 1;
            }
        }
        return -1;
    }
}
