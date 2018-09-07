/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        if (pA == null || pB == null) return null;
        while(pA != null || pB != null) {
            if (pA == null) pA = headB;
            if (pB == null) pB = headA;
            if (pA.val == pB.val) return pA;
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }
}
