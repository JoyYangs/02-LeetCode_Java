package 链表;

/**
 * @author joyeYang
 * @date 2020-04-12 16:49
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。(就是返回删除后的新的链表)
 *
 * 解法:
 * 一次遍历法: 需要一个哑结点
 * 两次遍历法
 */
public class T_19_删除链表的倒数第N个节点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode first = dummyNode;
        ListNode second = dummyNode;
        while (n-- >= 0) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummyNode.next;

    }

}
