package leetcode.linkedlist.n206_Reverse_Linked_List;

class Solution2 {
    private static ListNode lastNode;

    public ListNode reverseList(ListNode head) {
        recursive(head);
        return lastNode;
    }

    public ListNode recursive(ListNode head) {
        if (head.next != null) {
            recursive(head.next).next = head;
            head.next = null;
            return head;
        }
        lastNode = head;
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