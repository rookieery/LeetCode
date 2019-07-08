package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Solution888 {
    /**
     * 888. 公平的糖果交换
     * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
     * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。
     * （一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
     * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
     * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
     */
    //暴力法
    public int[] fairCandySwap1(int[] A, int[] B) {
        int[] arr = new int[2];
        int sumA = 0;
        int sumB = 0;
        for (int aA : A) {
            sumA += aA;
        }
        for (int aB : B) {
            sumB += aB;
        }
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (B[i] + (sumA - sumB) / 2 == A[j]) {
                    arr[0] = A[j];
                    arr[1] = B[i];
                    return arr;
                }
            }
        }
        throw null;
    }
    //借助集合优化
    public int[] fairCandySwap2(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        for (int aA : A) {
            sumA += aA;
        }
        for (int aB : B) {
            sumB += aB;
        }
        Set<Integer> setB = new HashSet<>();
        for (int aB : B) {
            setB.add(aB);
        }
        for (int aA : A) {
            if (setB.contains(aA + (sumB - sumA) / 2)) {
                return new int[]{aA, aA + (sumB - sumA) / 2};
            }
        }
        throw null;
    }
    //分别对两数组进行排序，然后用while
}
