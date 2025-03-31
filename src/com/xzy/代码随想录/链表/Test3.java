package com.xzy.代码随想录.链表;

public class Test3 {
    public static void main(String[] args) {
        String ret = "A" + "B" + "C";
    }


    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode pred = null;
        ListNode temp;

        while (curr != null) {
            temp = curr.next;
            curr.next = pred;
            pred = curr;
            curr = temp;
        }

        return pred;
    }
}
