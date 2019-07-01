/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head;
        ListNode end = head;
        int distance = 0;
        while(end != null) {
            if (distance < n + 1) {
                end = end.next;
                distance += 1;
            } else {
                front = front.next;
                end = end.next;
            }
        }


        if (distance == n) {
            return front.next;
        } else if (distance < n) {
            return front;
        } else {
            front.next = front.next.next;
            return head;
        }
    }
}
