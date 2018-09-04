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
    public int closestValue(TreeNode root, double target) {
        double residual = Double.MAX_VALUE;
        int result = 0;
        while(root != null) {
            double tmp = Math.abs(target - root.val);
            if (tmp < residual) {
                result = root.val;
                residual = tmp;
            }
            if (target < root.val) {
                root = root.left;
            } else if (target > root.val){
                root = root.right;
            } else {
                break;
            }
        }
        return result;
    }
}
