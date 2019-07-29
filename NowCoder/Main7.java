package NowCoder;

public class Main7 {
    /**
     * 链式A+B
     * 有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，
     * 也就是个位排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。
     * 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
     */
   class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        ListNode c = new ListNode(-1);
        ListNode curC = c;
        int addNum = 0;
        while(a != null || b != null || addNum != 0) {
            int aVal = a != null ? a.val : 0;
            int bVal = b != null ? b.val : 0;
            int sum = aVal + bVal +addNum;
            int cVal = sum %10;
            addNum = sum / 10;
            curC.next = new ListNode(cVal);
            curC = curC.next;
            a = a != null ? a.next : null;
            b = b != null ? b.next : null;
        }
        return c.next;
    }
}
