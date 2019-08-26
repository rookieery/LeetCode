package NowCoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main18 {
    /**
     * 马戏团
     * 搜狐员工小王最近利用假期在外地旅游，在某个小镇碰到一个马戏团表演，
     * 精彩的表演结束后发现团长正和大伙在帐篷前激烈讨论，小王打听了下了解 到， 马戏团正打算出一个新节目“最高罗汉塔”，
     * 即马戏团员叠罗汉表演。考虑到安全因素，要求叠罗汉过程中，站在某个人肩上的人应该既比自己矮又比自己瘦，或 相等。
     * 团长想要本次节目中的罗汉塔叠的最高，由于人数众多，正在头疼如何安排人员的问题。
     * 小王觉得这个问题很简单，于是统计了参与最高罗汉塔表演的所有 团员的身高体重，并且很快找到叠最高罗汉塔的人员序列。
     * 现在你手上也拿到了这样一份身高体重表，请找出可以叠出的最高罗汉塔的高度，这份表中马戏团员依 次编号为1到N。
     */
    //自定义类进行排序（身高为主，体重为辅），变成最长上升子序列问题（动规）
    static class People {
        int high;
        int weight;

        public People(int weight, int high) {
            this.high = high;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            People[] people = new People[N];
            for (int i = 0; i < N; i++) {
                people[sc.nextInt() - 1] = new People(sc.nextInt(), sc.nextInt());
            }
            Arrays.sort(people, new Comparator<People>() {
                @Override
                public int compare(People o1, People o2) {
                    int result = o1.high - o2.high;
                    if (result != 0) {
                        return result;
                    }
                    return o1.weight - o2.weight;
                }
            });
            int max = 1;
            int[] dp = new int[N];
            dp[0] = 1;
            for (int i = 1; i < N; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (people[i].weight > people[j].weight ||
                            (people[i].weight == people[j].weight && people[i].high == people[j].high)) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                if (dp[i] == 0) {
                    dp[i] = 1;
                }
                max = Math.max(max, dp[i]);
            }
            System.out.println(max);
        }
    }
}
