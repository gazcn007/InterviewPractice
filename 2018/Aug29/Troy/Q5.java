/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode dummyHead = new TreeLinkNode(0);
        TreeLinkNode prev = dummyHead;
        while(root != null) {
            if (root.right != null && root.left != null) {
                prev.next = root.left;
                root.left.next = root.right;
                prev = root.right;
            } else if (root.right != null) {
                prev.next = root.right;
                prev = root.right;
            } else if (root.left != null) {
                prev.next = root.left;
                prev = root.left;
            }
            root = root.next;
        }
        connect(dummyHead.next);
    }


}
