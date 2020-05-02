package 链表;

import java.util.List;

/**
 * @author joyeYang
 * @date 2020-04-12 17:16
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 *
 */
public class T_21_合并两个有序链表 {

    /** 递归: */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 递归基: 递归终止条件
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head;
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        }else {
            head = l2;
            l2 = l2.next;
        }

        ListNode cur = head; // 这一步不能少
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur = cur.next = l1; // 这里一定要把cur.next和cur都改变
                l1 = l1.next;
            }else {
                cur = cur.next = l2; // 这里一定要把cur.next和cur都改变
                l2 = l2.next;
            }
        }

        if (l1 == null) cur.next = l2;
        else if (l2 == null) cur.next = l1;

        return head;
    }

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        // 使用虚拟头节点 dummy head
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur = cur.next = l1;
                l1 = l1.next;
            }else {
                cur = cur.next = l2;
                l2 = l2.next;
            }
        }
        if (l1 == null) cur.next = l2;
        else if (l2 == null) cur.next = l1;

        return dummyHead.next;
    }

    public ListNode testMethod2(ListNode l1, ListNode l2) {
        if (l1 == null) return l1;
        if (l2 == null) return l1;

        ListNode head;
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        }else {
            head = l2;
            l2 = l2.next;
        }

        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur = cur.next = l1;
                l1 = l1.next;
            }else {
                cur = cur.next = l2;
                l2 = l2.next;
            }
        }

        if (l1 == null) cur.next = l2;
        else if (l2 == null) cur.next = l1;

        return head;
    }

    public ListNode testMethod3(ListNode l1, ListNode l2) {
        // 使用dummy来实现的话就省略了第二种方法的前面的值比较
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur = cur.next = l1;
                l1 = l1.next;
            }else {
                cur = cur.next = l2;
                l2 = l2.next;
            }
        }
        if (l1 == null) cur.next = l2;
        else if (l2 == null) cur.next = l1;

        return dummy.next;
    }


}
