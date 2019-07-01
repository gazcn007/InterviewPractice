/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        ListNode tmp = null;
        List<ListNode> pointers = new ArrayList<>();
        for(ListNode n : lists) {
            pointers.add(n);
        }
        boolean flag = true;
        while(flag) {
            flag = false;
            int min = Integer.MAX_VALUE;
            for(ListNode p : pointers) {
                if (p != null) {
                    flag = true;
                    if (p.val < min) min = p.val;
                }
            }
            // System.out.println(min);
            for(int i = 0; i < pointers.size(); i++) {
                ListNode p = pointers.get(i);
                if (p != null) {
                    if (p.val == min) {
                        if (result == null) {
                            result = new ListNode(p.val);
                            tmp = result;
                        } else {
                            tmp.next = new ListNode(p.val);
                            tmp = tmp.next;
                        }
                        pointers.set(i, p.next);
                    }
                }
            }
        }
        return result;
    }
}
