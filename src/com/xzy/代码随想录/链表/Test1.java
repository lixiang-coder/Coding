package com.xzy.代码随想录.链表;

public class Test1 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode();

    }

    /**
     * 力扣 203
     * https://leetcode.cn/problems/remove-linked-list-elements/
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        // 设置一个虚拟的头结点
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
