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
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() > 0) {
            int size = queue.size();
            TreeLinkNode last = null;
            while(size > 0) {
                TreeLinkNode cur = queue.poll();
                if (last == null) {
                    last = cur;
                } else {
                    last.next = cur;
                    last = cur;
                }
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                size--;
            }
        }
    }
}
