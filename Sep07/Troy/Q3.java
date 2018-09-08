/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = null;
        ListNode tmp = null;
        while(l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int n = (n1 + n2 + carry) % 10;
            carry = (n1 + n2 + carry) / 10;
            if (result == null) {
                result = new ListNode(n);
                tmp = result;
            } else {
                tmp.next = new ListNode(n);
                tmp = tmp.next;
            }

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            tmp.next = new ListNode(carry);
        }
        return result;
    }
}
