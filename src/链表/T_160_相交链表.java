package 链表;

/**
 * @author joyeYang
 * @date 2020-04-12 20:07
 *
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 *
 * 解法: 遍历，到头了就换一下头节点，直到相遇
 *
 * 面试题52_两个链表的第一个公共节点
 */
public class T_160_相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while(nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }
}
