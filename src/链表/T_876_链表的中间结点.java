package 链表;

/**
 * @author joyeYang
 * @date 2020-04-12 15:52
 *
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点
 *
 * 快慢指针法：一个一步一个两步，两步到尾的时候一步正好在中间
 */
public class T_876_链表的中间结点 {

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        // null.next 会报异常，需要考虑，所以要同时符合两个 != null
        while (fast != null && fast.next != null) {
            // 慢的指针走一步
            slow = slow.next;
            // 快的指针走两步
            fast = fast.next.next;
        }
        return slow;
    }
}
