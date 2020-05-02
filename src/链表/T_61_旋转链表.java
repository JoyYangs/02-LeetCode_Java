package 链表;

/**
 * @author joyeYang
 * @date 2020-04-25 21:34
 *
 * https://leetcode-cn.com/problems/rotate-list/
 */
public class T_61_旋转链表 {

    /** 待优化 */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;

        ListNode node1 = head;
        int len = 0;
        while(node1 != null) {
            len++;
            node1 = node1.next;
        }

        if (k == len || k == 0) return head;
        k = k > len ? k % len : k;
        int step = len - k;

        ListNode node2 = head;
        ListNode node3 = new ListNode(0);
        ListNode cur = node3;

        while(step > 0) {
            cur = cur.next = new ListNode(node2.val);
            node2 = node2.next;
            step--;
        }
        // 到此node2就是最终的前半部分，node3.next就是最终的后半部分了
        // 怎么把node2 和 node3.next连接上呢？？？
        ListNode dummy = new ListNode(0);
        ListNode cur1 = dummy;
        while(node2 != null) {
            cur1 = cur1.next = node2;
            node2 = node2.next;
        }
        cur1.next = node3.next;
        return dummy.next;
    }

}
