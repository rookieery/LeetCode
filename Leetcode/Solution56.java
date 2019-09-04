package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution56 {
    /**
     * 56. 合并区间
     * 给出一个区间的集合，请合并所有重叠的区间。
     */
    public int[][] merge(int[][] intervals) {
        int[][] arr = new int[intervals.length][];
        int j = 0;
        //按照左边界值进行升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            //while通过中间下标的关系有效的合成了一个最终区间
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            arr[j++] = new int[]{left,right};
        }
        return Arrays.copyOf(arr,j);
    }
}
