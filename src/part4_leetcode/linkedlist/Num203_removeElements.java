package part4_leetcode.linkedlist;



public class Num203_removeElements {
    public ListNode removeElements(ListNode head, int val) {
        //链表经典的剪枝条件
        if (head == null) return null;
        //创造虚拟头节点
        ListNode dummy = new ListNode(-1,head);
        //两个指针分别指向dummy和head
        ListNode pre = dummy;
        ListNode cur = head;
        //遍历链表
        while(cur != null){
            if (cur.val == val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
