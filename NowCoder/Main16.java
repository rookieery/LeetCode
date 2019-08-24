package NowCoder;

import java.util.*;

public class Main16 {
    /**
     * 查找兄弟单词
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = sc.next();
                list.add(str);
            }
            String tmp = sc.next();
            int k = sc.nextInt();
            Collections.sort(list);
            int count = 0;
            int index = 0;
            String strK = null;
            char[] tmpCh = tmp.toCharArray();
            Arrays.sort(tmpCh);
            for (String s : list) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                if (Arrays.equals(chars, tmpCh) && !s.equals(tmp)) {
                    count++;
                    index++;
                    if (index == k) {
                        strK = s;
                    }
                }
            }
            System.out.println(count);
            if (count >= k) {
                System.out.println(strK);
            }
        }
    }
}
