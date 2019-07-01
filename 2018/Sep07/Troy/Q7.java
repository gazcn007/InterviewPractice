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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        } else if (nums.length == 1) {
            return new TreeNode(nums[0]);
        } else {
            int maxIdx = maxIndex(nums);
            TreeNode result = new TreeNode(nums[maxIdx]);
            result.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIdx));
            result.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIdx + 1, nums.length));
            return result;
        }
    }

    public int maxIndex(int[] nums) {
        int result = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                result = i;
            }
        }
        return result;
    }
}
