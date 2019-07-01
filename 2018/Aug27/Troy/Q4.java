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
    boolean valid = true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return valid;
    }

    public int height(TreeNode cur) {
        if (cur == null) return 0;
        if (cur.right == null && cur.left == null) return 1;
        int rightHeight = height(cur.right);
        int leftHeight = height(cur.left);
        if (Math.abs(rightHeight - leftHeight) > 1) valid = false;
        return Math.max(rightHeight, leftHeight) + 1;
    }
}
