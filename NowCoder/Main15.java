package NowCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main15 {
    /**
     * 求和
     * 输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
     */
    private static List<List<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<List<Integer>> lists = combinationSum(m, n);
            for (List list : lists) {
                for (Object o : list) {
                    System.out.print(o + " ");
                }
                System.out.println();
            }
        }
    }

    private static List<List<Integer>> combinationSum(int m, int n) {
        backtrack(m, n, new ArrayList<Integer>(), 0, 0);
        return lists;
    }

    private static void backtrack(int m, int n, ArrayList<Integer> list, int sum, int index) {
        if (sum == m) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = index + 1; i <= n; i++) {
            if (i + sum <= m) {
                sum += i;
                list.add(i);
                backtrack(m, n, list, sum, i);
                sum -= i;
                list.remove(list.size() - 1);
            } else {
                break;
            }
        }
    }
}
