package com.jkl.leetcode.node;

/**
 * 《链表题：删除链表中的节点》
 * <p>
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * <p>
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], node = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * <p>
 * 说明:
 * <p>
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 *
 * @author jkl,  Date on 2019/8/13.
 */
public class Node {


    /**
     * 《链表题一：删除链表中的节点》
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     * 输入: head = [4,5,1,9], node = 5
     */
    private static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 《链表题：删除链表的倒数第N个节点》
     * <p>
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode perNode = head;
        ListNode nowNode = head;
        for (int i = 0; i < n; i++) {
            perNode = perNode.next;
        }
        if (perNode == null) {
            return nowNode.next;
        }
        while (perNode.next != null) {
            perNode = perNode.next;
            nowNode = nowNode.next;
        }
        nowNode.next = nowNode.next.next;
        return head;
    }


    /**
     * 《链表题：反转链表》
     * 反转一个单链表。
     * 示例:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     */
    public ListNode reverseList(ListNode head) {
        ListNode per = null;
        ListNode cur = head;
        while (cur != null) {
            //1. 保存当前节点
            ListNode next = cur.next;
            //2. 下一个节点指向前一个节点per
            cur.next = per;
            //3. 前一个节点per指向当前节点cur
            per = cur;
            //4. 当前节点指向下一个节点
            cur  = next;
        }
        return per;
    }


    /**
     * Definition for singly-linked list
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
