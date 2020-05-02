package 链表;


/**
 * @author joyeYang
 * @date 2020-04-12 16:26
 *
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 解法: 直接按照节点对应相加，需要考虑链表到达尾部的情况和进位的情况
 */
public class T_02_两数相加 {
    /**
     * 这个本质上和直接把两个字符串数相加是一样的，只不过是要判断listnode是否为空
     * 因为这个直接是倒序的，所以就正常while循环遍历两个listnode就好
     * 直接取出来里面的值就是int类型的
     * 不过要注意的是我们需要一个dummy来存储每一步计算出来的值
     * 并且这个值也是要考虑是否需要进位的
     * 并且要每次将cur的指针指向他的next
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int temp = v1 + v2 + carry;
            carry = temp / 10;
            cur.next = new ListNode(temp % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return head.next;
    }
}
