package NowCoder;

import java.util.Scanner;

public class Main5 {
    /**
     * DNA序列
     *一个DNA序列由A/C/G/T四个字母的排列组合组成。
     * G和C的比例（定义为GC-Ratio）是序列中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长 度）。
     * 在基因工程中，这个比例非常重要。因为高的GC-Ratio可能是基因的起始点。
     *  给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = sc.nextInt();
        int[] dp = new int[str.length() - n + 1];
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'C' || str.charAt(i) == 'G') {
                dp[0]++;
            }
        }
        int max = dp[0];
        for (int i = n; i < str.length(); i++) {
            if ((str.charAt(i) == 'C' || str.charAt(i) == 'G') &&
                    (str.charAt(i - n) != 'C' && str.charAt(i - n) != 'G')) {
                dp[i - n + 1] = dp[i - n] + 1;
            } else if ((str.charAt(i) != 'C' && str.charAt(i) != 'G') &&
                    (str.charAt(i - n) == 'C' || str.charAt(i - n) == 'G')) {
                dp[i - n + 1] = dp[i - n] - 1;
            } else {
                dp[i - n + 1] = dp[i - n];
            }
            max = Math.max(max, dp[i - n + 1]);
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max) {
                System.out.println(str.substring(i, i + n));
                break;
            }
        }
    }
}
