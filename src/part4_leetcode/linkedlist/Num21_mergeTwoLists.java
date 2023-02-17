package part4_leetcode.linkedlist;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mumu
 * @since 2023-02-17
 */
public class Num21_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            }else{
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        if(list1 == null){
            cur.next =  list2;
        }else{
            cur.next =  list1;
        }

        return dummyNode.next;
    }
}
