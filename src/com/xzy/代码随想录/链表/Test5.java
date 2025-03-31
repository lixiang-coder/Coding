package com.xzy.代码随想录.链表;

public class Test5 {

    /**
     * 力扣 19
     * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumy = new ListNode();
        dumy.next = head;

        ListNode fast = dumy;
        ListNode slow = dumy;

        // 快指针先走n步
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        // 快慢指针一起走
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除节点
        slow.next = slow.next.next;

        return dumy.next;

    }
}
