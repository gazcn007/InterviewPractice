/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        if (k == 0) return head;
        ListNode resultList = locateStartNode(head, k);
        ListNode resultHead = resultList;
        int length = length(head);
        while (length > 0) {
            if (resultHead.next == null) {
                resultHead.next = head;
            } else {
                resultHead = resultHead.next;
            }
            length -= 1;
        }
        if (resultList == null) return resultList;
        resultHead.next = null;
        return resultList;
    }
    public ListNode locateStartNode(ListNode head, int k) {

        int length = length(head);
        if (length == 0) return head;
        if (k <= length) k = length - k;
        if (k > length) k = length - k % length;
        if (k == length) return head;

        while (k > 0) {
            head = head.next;
            k -= 1;
        }
        return head;
    }
    public int length(ListNode head) {
        int length = 0;
        while(head != null) {
            length += 1;
            head = head.next;
        }
        return length;
    }
}
