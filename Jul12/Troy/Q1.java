/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return false;
        ListNode fastPointer = head.next;
        while (true) {
            if (head.val == fastPointer.val) {
                return true;
            }
            if (fastPointer.next == null || fastPointer.next.next == null) {
                return false;
            }
            head = head.next;
            fastPointer = fastPointer.next.next;
        }
    }
}
