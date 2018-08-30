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
    int answer = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return answer;
        helper(root);
        return answer;
    }

    public boolean helper(TreeNode root) {
        if (root.right == null && root.left == null) {
            answer++;
            return true;
        }

        if (root.right != null && root.left == null) {
            boolean right = helper(root.right);
            boolean tmp = right && root.val == root.right.val;
            if (tmp) answer++;
            return tmp;
        } else if (root.left != null && root.right == null) {
            boolean left = helper(root.left);
            boolean tmp = left && root.val == root.left.val;
            if (tmp) answer++;
            return tmp;
        } else {
            boolean right = helper(root.right);
            boolean left = helper(root.left);
            boolean tmp = right && left && root.val == root.left.val && root.val == root.right.val;
            if (tmp) answer++;
            return tmp;
        }

    }
}
