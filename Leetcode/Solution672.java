package LeetCode;

public class Solution672 {
    /**
     * 672. 灯泡开关 Ⅱ
     * 现有一个房间，墙上挂有 n 只已经打开的灯泡和 4 个按钮。
     * 在进行了 m 次未知操作后，你需要返回这 n 只灯泡可能有多少种不同的状态。
     * 假设这 n 只灯泡被编号为 [1, 2, 3 ..., n]，这 4 个按钮的功能如下：
     * 将所有灯泡的状态反转（即开变为关，关变为开）
     * 将编号为偶数的灯泡的状态反转
     * 将编号为奇数的灯泡的状态反转
     * 将编号为 3k+1 的灯泡的状态反转（k = 0, 1, 2, ...)
     */
    //找规律（周期）
    public int flipLights(int n, int m) {
        if(n == 0 || m == 0){
            return 1;
        }
        if(m == 1){
            return n<3 ? n+m:4;
        }
        else if (m == 2 ){
            return n<3 ? n*m:7;
        }
        else{
            return n<3 ? 2*n:8;
        }
    }
}
