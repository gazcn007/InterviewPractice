/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return result;
    }

    public TreeNode helper(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null) return null;
        TreeNode left = helper(cur.left, p, q);
        TreeNode right = helper(cur.right, p , q);
        if (left == null && right == null) {
            if (cur.val == p.val) return p;
            if (cur.val == q.val) return q;
            return null;
        } else if (left == null && right != null) {
            if ((cur.val == p.val && right.val == q.val) ||
               (cur.val == q.val && right.val == p.val)) {
                result = cur;
            }
            return right;
        } else if (left != null && right == null) {
            if ((cur.val == p.val && left.val == q.val) ||
               (cur.val == q.val && left.val == p.val)) {
                result = cur;
            }
            return left;
        } else {
            result = cur;
            return q;
        }
    }
}
