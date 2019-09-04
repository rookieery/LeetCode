package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution179 {
    /**
     * 179. 最大数
     * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
     */
    //自定义排序
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        Collections.sort(list,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                //数值越界
                //return (-1) * (Integer.parseInt(a) - Integer.parseInt(b));
                return -1 * (a.compareTo(b));
            }
        });
        System.out.println(list);
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        String result = sb.toString();
        if (result.charAt(0)=='0') {
            return "0";
        } else {
            return result;
        }
    }
}
