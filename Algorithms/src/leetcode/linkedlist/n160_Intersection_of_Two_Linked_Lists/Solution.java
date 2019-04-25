package leetcode.linkedlist.n160_Intersection_of_Two_Linked_Lists;

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ArrayList<ListNode> headAStack = new ArrayList<>();
        ArrayList<ListNode> headBStack = new ArrayList<>();

        while (headA != null) {
            headAStack.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            headBStack.add(headB);
            headB = headB.next;
        }

        int headAStackSize = headAStack.size();
        int headBStackSize = headBStack.size();

        while (headAStackSize > 0 && headBStackSize > 0 && headAStack.get(headAStackSize - 1) == headBStack.get(headBStackSize - 1)) {
            headAStackSize--;
            headBStackSize--;
        }

        if (headAStackSize == headAStack.size()) {
            return null;
        }

        return headAStack.get(headAStackSize);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}