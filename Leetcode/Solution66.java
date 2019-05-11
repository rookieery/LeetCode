package LeetCode;

public class Solution66 {
    //66.加一
    //给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
    //最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
    //你可以假设除了整数 0 之外，这个整数不会以零开头。
    public int[] plusOne(int[] digits) {
        int[] arr = new int[digits.length+1];
        for (int i = 0; i < digits.length; i++) {
            arr[i] = digits[digits.length-1-i];
        }
        int i = 0;
        int flag = 1;
        while (i <= digits.length) {
            if (arr[i]+flag == 10) {
                arr[i] = 0;
                flag = 1;
            }
            else {
                arr[i] += flag;
                flag = 0;
            }
            i++;
        }
        if (arr[digits.length] == 1){
            for (int j = 0; j < arr.length; j++) {
                int tmp = arr[j];
                arr[j] = arr[arr.length-1];
                arr[arr.length-1] = tmp;
            }
            return arr;
        }
        else {
            for (int j = 0; j < digits.length; j++) {
                digits[j] = arr[digits.length-1-j];
            }
            return digits;
        }
    }
}
