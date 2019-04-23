package leetcode.linkedlist.n206_Reverse_Linked_List;


class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode previousNode = null;
        ListNode twoNodeBefore;
        if (head == null) {
            return head;
        }
        while (head.next != null) {
            twoNodeBefore = head.next;
            head.next = previousNode;
            previousNode = head;
            head = twoNodeBefore;
        }
        head.next = previousNode;
        return head;
    }

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}