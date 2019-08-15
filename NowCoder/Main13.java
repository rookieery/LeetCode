package NowCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main13 {
    /**
     * 木棒拼图
     * 有一个由很多木棒构成的集合，每个木棒有对应的长度，
     * 请问能否用集合中的这些木棒以某个顺序首尾相连构成一个面积大于 0 的简单多边形且所有木棒都要用上，
     * 简单多边形即不会自交的多边形。
     * 初始集合是空的，有两种操作，要么给集合添加一个长度为 L 的木棒，要么删去集合中已经有的某个木棒。
     * 每次操作结束后你都需要告知是否能用集合中的这些木棒 构成一个简单多边形。
     */
    //max < sum - max
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] daos = new int[n];
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                daos[i] = sc.nextInt();
                nums[i] = sc.nextInt();
            }
            List<Integer> list = new ArrayList<>();
            int max = 0;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (daos[i] == 1) {
                    sum += nums[i];
                    list.add(nums[i]);
                    max = Math.max(max, nums[i]);
                } else {
                    sum -= nums[i];
                    list.remove((Integer) nums[i]);
                    if (nums[i] == max) {
                        for (int num : list) {
                            max = Math.max(0, num);
                        }
                    }
                }
                if (list.size() > 2 && max < sum - max) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}
