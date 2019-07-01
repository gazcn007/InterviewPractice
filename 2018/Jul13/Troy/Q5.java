/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode reverse = null;
        ListNode temp = head;
        while(temp != null) {
            ListNode r = new ListNode(temp.val);
            r.next = reverse;
            reverse = r;
            temp = temp.next;
        }

        while(head != null) {
            if (head.val != reverse.val) {
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }
}
