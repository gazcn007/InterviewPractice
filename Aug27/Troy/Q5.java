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
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) return null;
        if (len == 1) {
            TreeNode root = new TreeNode(nums[0]);
            return root;
        }
        int medianIdx = len % 2 == 0 ? len / 2 - 1 : len / 2;
        TreeNode root = new TreeNode(nums[medianIdx]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, medianIdx));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, medianIdx + 1, len));
        return root;
    }
}
