package NowCoder;

import java.util.*;

public class Main11 {
    /**
     * 简单错误记录
     * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
     * 1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
     * 2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
     * 3.输入的文件可能带路径，记录文件名称不能带路径
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();//Map存放数据
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s == null || "".equals(s)) break;
            String[] split = s.split("\\s");
            String key = split[0].substring(split[0].lastIndexOf('\\') + 1) + " " + split[1];
            map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());//List排序
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (int i = 0; i < 8; i++) {
            String[] split = list.get(i).getKey().split("\\s");//字符串数组输出
            if (split[0].length() > 16) {
                split[0] = split[0].substring(split[0].length() - 16);
            }
            System.out.println(split[0] + " " + split[1] + " " + list.get(i).getValue());
        }
    }
}
