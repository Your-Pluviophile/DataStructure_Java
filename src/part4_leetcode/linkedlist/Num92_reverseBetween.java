package part4_leetcode.linkedlist;

public class Num92_reverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //用left,right 指向要反转的区间节点
        //用pre 保存 left前一个节点，用 cur保存right后一个节点

        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        //用pre 保存 left前一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        //用 cur保存right后一个节点
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode cur = rightNode.next;
        ListNode leftNode = pre.next;

        //切开连接并反转
        pre.next = null;
        rightNode.next = null;
        reverse(leftNode);
        //连接
        pre.next = rightNode;
        leftNode.next = cur;
        return dummy.next;
    }

    private void reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;

        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
    }
}
