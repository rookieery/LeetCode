package NowCoder;

public class Main2 {
    /**
     *生成格雷码
     * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，
     * 请编写一个函数，使用递归的方法生成N位的格雷码。
     * 给定一个整数n，请返回n位的格雷码，顺序为从0开始。
     */
    public static String[] getGray(int n) {
        String[][] dp = new String[n][1 << n];
        dp[0][0] = "0";
        dp[0][1] = "1";
        for (int i = 1; i < n; i++) {
            int count = 0;
            while (count < (1 << i)) {
                dp[i][count] = "0" + dp[i - 1][count];
                count++;
            }
            int tmp = 0;
            int amd = count;
            count = (1 << (i + 1)) - 1;
            while (count >= amd) {
                dp[i][count--] = "1" + dp[i - 1][tmp++];
            }
        }
        return dp[n - 1];
    }

    public static String[] getGray1(int n) {
        int m = 1<<n;
        String[] r = new String[m];
        if(n==1){
            r[0] = "0";
            r[1] = "1";
            return r;
        }
        String[] temp = getGray1(n-1);
        int j = 0;
        for(int i = 0;i<m;i++){
            if(i<m/2){
                r[i] = "0"+temp[j++];
            }else{
                r[i] = "1"+temp[--j];
            }
        }
        return r;
    }
}
