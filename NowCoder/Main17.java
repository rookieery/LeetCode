package NowCoder;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main17 {
    /**
     * 简单错误记录
     * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
     * 处理： 1、 记录最多8条错误记录，循环记录，对相同的错误记录（净文件名称和行号完全匹配）只记录一条，错误计数增加；
     * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
     * 3、 输入的文件可能带路径，记录文件名称不能带路径。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //LinkedHashMap可以保证按照存入顺序
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        int count = 0;
        while (sc.hasNextLine()) {
            String str_1 = sc.nextLine();
            //读取一行  存入一行至map中
            mapDispose(map, str_1);
        }
        // 输出后8位
        for (String st : map.keySet()) {
            count++;
            if (count > (map.size() - 8)) {
                System.out.println(st + " " + map.get(st));
            }
        }
    }

    public static void mapDispose(Map<String, Integer> map, String str) {
        // "\\s" 是按照单个空格 、多个空格、tab制表符分割
        String[] strArr = str.split("\\s+");
        // "\\\\"按照反斜杠分割
        String[] nameArr = strArr[0].split("\\\\");
        int num = Integer.parseInt(strArr[1]);
        String name = nameArr[nameArr.length - 1];
        // 取最后有效的16个字符为最终文件名
        if (name.length() > 16) {
            name = name.substring(name.length() - 16);
        }
        // 将文件名和行号组成字符串 作为map的key值存放
        String key = name + " " + num;
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }
}
