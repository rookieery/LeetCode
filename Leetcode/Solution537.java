package LeetCode;

public class Solution537 {
    /**
     * 537. 复数乘法
     * 给定两个表示复数的字符串。
     * 返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。
     */
    public String complexNumberMultiply(String a, String b) {
        StringBuilder st = new StringBuilder();
        int[] arrA = getInt(a);
        int[] arrB = getInt(b);
        st.append(arrA[0] * arrB[0] - arrA[1] * arrB[1]);
        st.append('+');
        st.append(arrA[0] * arrB[1] + arrA[1] * arrB[0]);
        st.append('i');
        return st.toString();
    }

    private int[] getInt(String s) {
        int[] arr = new int[2];
        StringBuilder sb = new StringBuilder();
        StringBuilder sp = new StringBuilder();
        int i = 0;
        while (s.charAt(i) != '+') {
            sb.append(s.charAt(i++));
        }
        i++;
        while (s.charAt(i) != 'i') {
            sp.append(s.charAt(i++));
        }
        arr[0] = new Integer(sb.toString());
        arr[1] = new Integer(sp.toString());
        return arr;
    }
}
