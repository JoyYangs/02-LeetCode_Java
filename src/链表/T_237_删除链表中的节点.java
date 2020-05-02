package 链表;

/**
 * @author joyeYang
 * @date 2020-04-12 15:43
 *
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 *
 * 同: 面试题02_03_删除中间节点
 *
 * 解法：把当前节点的值替换为下一节点的值，把当前节点的next替换为下一节点的next，就相当于是将当前节点删除了
 */
public class T_237_删除链表中的节点 {

    // 给出的节点就是要求删除的那个节点(非末尾)
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}

