package part4_leetcode.linkedlist;



public class Num19_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //删除链表的倒数第n个节点
        //只要快慢指针相差 n 个结点即可
        if (head == null) return null;

        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;


    }
}
