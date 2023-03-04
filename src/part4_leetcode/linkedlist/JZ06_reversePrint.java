package part4_leetcode.linkedlist;

/**
 * @author mumu
 * @since 2023-03-04
 */
public class JZ06_reversePrint {
    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode node = head;
        while(node != null){
            count++;
            node = node.next;
        }
        int[] res = new int[count];
        node = head;
        for(int i = count - 1;i >= 0;--i){
            res[i] = node.val;
            node = node.next;
        }
        return res;
    }
}
