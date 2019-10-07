package NowCoder;

import java.util.*;

public class Main21 {
    /**
     *  给定一个只包含小写字母的字符串，我们通过如下规则分割它：
     * 1.一个片段中包含的字符不允许出现在其他片段内。
     * 2.分割的片段数应尽可能的多。
     * 请实现一个函数，输出分割的片段。
     * 例如：输入aabbbacceddefgkifk 输出为 aabbba cc edde fgkifk
     */
    private List getMaxDivision(String str) {
        String[] strings = new String[str.length()];
        Map<Integer, Set<Character>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int index = 0;
        //先做按照单字符进行一次顺序粗略切分
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            //倒序遍历切分效果更好
            for (int j = str.length() - 1; j >= i; j--) {
                char tmp = str.charAt(j);
                if (tmp == ch) {
                    strings[index++] = str.substring(i, j + 1);
                    i = j;
                    break;
                }
            }
        }
        //将每一个切分的字串的所含字符记录下来
        for (int i = 0; i < index; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < strings[i].length(); j++) {
                set.add(strings[i].charAt(j));
            }
            map.put(i,set);
        }
        //把有重复的漏网之鱼进行合并
        for (int i = 0; i < index; i++) {
            Set<Character> tmpSet = map.get(i);
            boolean flag = false;
            int a = 0;
            for (int j = index - 1; j > i; j--) {
                Set<Character> set = map.get(j);
                for (char ch : tmpSet) {
                    if (set.contains(ch)) {
                        a = j;
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (flag) {
                StringBuilder sb = new StringBuilder();
                for (int j = i; j <= a; j++) {
                    sb.append(strings[j]);
                }
                list.add(sb.toString());
                i = a;
            } else {
                list.add(strings[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Main21 s = new Main21();
        String str = "aabbbacceddefgkifk";
        System.out.println(s.getMaxDivision(str));
    }
}
