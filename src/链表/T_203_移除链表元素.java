package 链表;

/**
 * @author joyeYang
 * @date 2020-04-12 20:47
 */
public class T_203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel, cur = head;

        while(cur != null) {
            if (cur.val == val) prev.next = cur.next;
            else prev = cur;
            cur = cur.next;
        }

        return sentinel.next;
    }
}
