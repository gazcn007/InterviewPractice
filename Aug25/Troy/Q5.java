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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode cur = root;
        while(true) {
            if (val > cur.val) {
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    return root;
                }

                cur = cur.right;
            } else if (val < cur.val) {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    return root;
                }
                cur = cur.left;
            }
        }
    }
}
