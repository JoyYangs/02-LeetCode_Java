package 链表;

/**
 * @author joyeYang
 * @date 2020-05-03 15:38
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次
 */
public class T_83_删除排序链表中的重复元素 {

    public ListNode deleteDuplicates(ListNode head) {
        // 根据题目情况可以选择不写这句
//        if (head == null || head.next == null) return head;
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            }else {
                // 不然会死循环
                node = node.next;
            }
        }
        return head;
    }
}
