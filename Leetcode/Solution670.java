package LeetCode;

import java.util.Arrays;

public class Solution670 {
    /**
     * 670. 最大交换
     * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
     */
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        char[] tmp = chars.clone();
        //排序比较找不同
        Arrays.sort(tmp);
        int index = 0;
        int i = tmp.length - 1;
        while (i >= 0 && tmp[i] == chars[index]) {
            i--;
            index++;
        }
        if (i < 0) {
            return Integer.parseInt(String.copyValueOf(chars));
        }
        //倒序查找需要交换的因素的位置
        char target = tmp[i];
        int j = chars.length - 1;
        while (j > index && chars[j] != target) {
            j--;
        }
        chars[j] = chars[index];
        chars[index] = target;
        return Integer.parseInt(String.copyValueOf(chars));
    }
}
