/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        Node dummyHead = new Node(0, null, null, null);
        Node curr = dummyHead;
        while(head != null) {
            if (curr == dummyHead) {
                curr.next = new Node(head.val, null, null, null);
            } else {
                curr.next = new Node(head.val, curr, null, null);
            }

            curr = curr.next;
            if (head.child != null) {
                curr.next = flatten(head.child);
                curr.next.prev = curr;
                while(curr.next !=null) {
                    curr = curr.next;
                }
            }
            head = head.next;
        }
        return dummyHead.next;
    }

}
