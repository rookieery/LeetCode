package NowCoder;

public class Main6 {
    /**
     * 链表分割
     * 编写代码，以给定值x为基准将链表分割成两部分，
     * 所有小于x的结点排在大于或等于x的结点之前 给定一个链表的头指针 ListNode* pHead，
     * 请返回重新排列后的链表的头指针。
     * 注意：分割以后保持原来的数据顺序不变。
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode cur = pHead;
        ListNode sHead = new ListNode(-1);
        ListNode bHead = new ListNode(-1);
        ListNode sCur = sHead;
        ListNode bCur = bHead;
        while (cur != null) {
            if (cur.val < x) {
                sCur.next = new ListNode(cur.val);
                sCur = sCur.next;
            } else {
                bCur.next = new ListNode(cur.val);
                bCur = bCur.next;
            }
            cur = cur.next;
        }
        cur = sHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = bHead.next;
        return sHead.next;
    }
}
