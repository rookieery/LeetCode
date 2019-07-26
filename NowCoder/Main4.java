package NowCoder;

import java.util.*;

public class Main4 {
    /**
     * 火车进站
     * 给定一个正整数N代表火车数量，0<N<10，
     * 接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号。
     * 要求以字典序排序输出火车出站的序列号。
     */
    //回溯
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String in = "";
        String out = "";
        function(str, in, out);
        list.sort(Comparator.comparingInt(Integer::valueOf));//按照字符串的数值大小重写排序标准
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void function(String remain, String in, String out) {
        if (remain.length() == 0) {
            list.add(out + in);
        } else {
            if (in.length() == 0) {//此时只能把remain内的火车进入一个到in里面
                function(remain.substring(1, remain.length()), in + remain.charAt(0), out);
            } else {
                for (int i = 0; i <= in.length(); i++) {//模拟边入边出的场景
                    //i = 0保证remain的火车全部进入in内
                    //把remain内的火车进入一个到in里面，并且让in里面的火车出i个到out内
                    function(remain.substring(1, remain.length()), remain.charAt(0) + in.substring(i, in.length()), out + in.substring(0, i));
                }
            }
        }
    }

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            long start1 = System.currentTimeMillis();
            int n = in.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = in.nextInt();
            }
            int start = 0;
            ArrayList<int[]> result = new ArrayList<int[]>();

            Permutation(A, start, n, result);
            Set<String> sortResult = new TreeSet<String>();

            for (int[] out : result) {
                if (isLegal(A, out, n)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < n - 1; i++) {
                        sb.append(out[i] + " ");
                    }
                    sb.append(out[n - 1]);
                    sortResult.add(sb.toString());
//                  System.out.println(sb.toString());
                }
            }
            for (String list : sortResult) {
                System.out.println(list);
            }
            long end1 = System.currentTimeMillis();
            System.out.println(end1 - start1);
        }
        in.close();
    }

    private static boolean isLegal(int[] in, int[] out, int n) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int i = 0;
        int j = 0;
        while (i < n) { // in 还有元素的时候都需要判断
            if (in[i] == out[j]) { //  相等时候就不用入栈，直接后移
                i++;
                j++;
            } else {
                if (stack.isEmpty()) { //空stack 就只有入栈了
                    stack.push(in[i]);
                    i++;
                } else {
                    int top = stack.peek(); // 栈顶元素相等，进行出栈
                    if (top == out[j]) {
                        j++;
                        stack.pop();
                    } else if (i < n) { //  不等时候入栈
                        stack.push(in[i]);
                        i++;
                    }
                }
            }
        }
        while (!stack.isEmpty() && j < n) { // in 的结束后，栈中元素进程出栈序列应该和out剩余的元素 相同
            int top = stack.pop();
            if (top == out[j]) {
                j++;
            } else {
                return false;
            }
        }
        return true;

    }

    /**
     * 求出所有排列
     *
     * @param A
     * @param start
     * @param n
     * @param result
     */
    private static void Permutation(int[] A, int start, int n, ArrayList<int[]> result) {
        if (start == n) {
            return;
        }
        if (start == n - 1) {
            int[] B = A.clone();
            result.add(B);
            return;
        }
        for (int i = start; i < n; i++) {
            swap(A, start, i);
            Permutation(A, start + 1, n, result);
            swap(A, start, i);
        }

    }

    private static void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}
