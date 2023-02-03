package part4_leetcode.linkedlist;

public class Num234_isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        //找出mid
        ListNode mid = findIndex(head);
        //反转后半部分
        ListNode end = reverse(mid.next);
        //比较两个链表
        ListNode p1 = head;
        ListNode p2 = end;
        boolean res = true;
        while (res && p2 != null) {
            if (p1.val != p2.val) {
                res = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        //把链表接回来
        mid.next = reverse(end);
        return res;

    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private ListNode findIndex(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
