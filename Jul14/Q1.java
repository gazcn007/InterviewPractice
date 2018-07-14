/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode resultHead = null;
        while(l1 != null || l2 != null) {
            if (l1 == null) {
                if (result == null) return l2;
                result.next = l2;
                break;
            } else if (l2 == null) {
                if (result == null) return l1;
                result.next = l1;
                break;
            } else {
                if (l1.val < l2.val) {
                    if (result == null) {
                        result = new ListNode(l1.val);
                        resultHead = result;
                    } else {
                        result.next = new ListNode(l1.val);
                        result = result.next;
                    }
                    l1 = l1.next;
                } else {
                     if (result == null) {
                        result = new ListNode(l2.val);
                        resultHead = result;
                    } else {
                        result.next = new ListNode(l2.val);
                        result = result.next;
                    }
                    l2 = l2.next;
                }
            }
        }
        return resultHead;
    }
}
