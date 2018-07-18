/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode reverse = null;
        while(head != null) {
            ListNode r = new ListNode(head.val);
            r.next = reverse;
            reverse = r;
            head = head.next;
        }
        return reverse;
    }
}
