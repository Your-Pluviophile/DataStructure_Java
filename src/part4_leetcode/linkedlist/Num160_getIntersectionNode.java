package part4_leetcode.linkedlist;

public class Num160_getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        //求长度
        while (curA != null) {
            curA = curA.next;
            lenA++;
        }
        while (curB != null) {
            curB = curB.next;
            lenB++;
        }
        //求差
        int gap = Math.abs(lenA - lenB);
        // 让curA为最长链表的头，lenA为其长度
        curA = lenA > lenB ? headA : headB;
        curB = lenA > lenB ? headB : headA;

        //末尾位置对齐
        while (gap-- > 0) {
            curA = curA.next;
        }
        //遍历
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
