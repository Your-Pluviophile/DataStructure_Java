package part4_leetcode.linkedlist;

public class Num24_swapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1,head);
        //cur指向要交换的两个节点的前一个节点
        //first指向第一个节点，second指向第二个
        //temp指向要交换的两个节点的后一个节点

        ListNode cur = dummy;
        ListNode firstNode,secondNode,temp;
        while (cur.next != null && cur.next.next != null){
            firstNode = cur.next;
            secondNode = cur.next.next;
            temp = cur.next.next.next;

            cur.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = temp;

            cur = firstNode;
        }
        return dummy.next;
    }
}
