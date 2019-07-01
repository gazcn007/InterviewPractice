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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        int leftVal = Math.min(p.val, q.val);
        int rightVal = Math.max(p.val, q.val);
        while(true) {
            if (leftVal <= cur.val && rightVal >= cur.val) break;
            if (leftVal > cur.val) cur = cur.right;
            if (rightVal < cur.val) cur = cur.left;
        }
        return cur;
    }
}
