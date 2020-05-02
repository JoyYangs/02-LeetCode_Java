package 链表;

import java.util.List;

/**
 * @author joyeYang
 * @date 2020-04-12 15:58
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * 解法：递归或者迭代两种方式
 *
 */
public class T_206_反转链表 {

    /** 递归: 要考虑终止条件，否则死循环 */
    public ListNode reverseList1(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode cur = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    /** 迭代: 先保存head.next 然后依次更换指向 */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = node;
            node = head;
            head = temp;
        }
        return node;
    }


    /** 递归: 要考虑终止条件，否则死循环 */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = reverseList(head.next);
        /** 每一步递归就是将原链表分为两部分: head节点和剩下的全部节点，剩下的全部作为一个整体新的head，
         * 需要将这个head节点指向head节点的next的next，也就是把刚分割的两部分串起来 */
        head.next.next = head;
        /** 置为null是为了防止死循环 */
        head.next = null;
        return cur;
    }
}
