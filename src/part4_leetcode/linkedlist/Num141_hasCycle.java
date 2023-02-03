package part4_leetcode.linkedlist;

public class Num141_hasCycle {
    public boolean hasCycle(ListNode head) {
        //至少两个节点才能成环。
        if (head == null || head.next == null) return false;
        //快慢指针
        ListNode slow = head;
        ListNode fast = head.next;

        //如果存在环，则fast必然在某个时刻等于slow
        while(fast != slow){
            //如果不存在环，fast会走到null的位置
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
