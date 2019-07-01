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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        boolean result = false;
        if (root.right == null && root.left == null) return root.val == sum;
        if (root.left != null) result = result || hasPathSum(root.left, sum - root.val);
        if (root.right != null) result = result || hasPathSum(root.right, sum - root.val);
        return result;
    }
}
