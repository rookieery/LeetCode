package LeetCode;

public class Solution1053 {
    /**
     * 1053. 交换一次的先前排列
     * 给你一个正整数的数组 A（其中的元素不一定完全不同），
     * 请你返回可在 一次交换（交换两数字 A[i] 和 A[j] 的位置）后得到的、按字典序排列小于 A 的最大可能排列。
     * 如果无法这么操作，就请返回原数组。
     */
    //从前往后查找，发现数据变小时记录下来left和right，后续如果有数据变大并且不大于left，更新right即可
    public int[] prevPermOpt11(int[] A) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                left = i;
                right = i + 1;
            } else if (A[i] < A[i + 1] && A[left] > A[i + 1]) {
                right = i + 1;
            }
        }
        int tmp = A[left];
        A[left] = A[right];
        A[right] = tmp;
        return A;
    }
    //从后往前查找，找到最后一个降序点，并且找到离降序点最近得那一个小于降序点值得最大值点，进行交换即可
    public int[] prevPermOpt12(int[] A) {
        if(A.length <= 1) return A;
        for(int i = A.length - 1; i >= 1; i--){
            //从后往前，找到第一个降序点(即序列得最后一个降序点)
            if(A[i - 1] > A[i]){
                //从后往前，找到符合条件得交换点
                int j = A.length - 1;
                while(A[j] >= A[i - 1] || A[j] == A[j - 1])
                    j--;
                //开始交换
                int t = A[j];
                A[j] = A[i - 1];
                A[i - 1] = t;
                break;
            }
        }
        return A;
    }
}
