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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, inorderMap, 0, preorder.length - 1);
    }
    public TreeNode helper(int[] preorder, HashMap<Integer, Integer> inorderMap, int pStart, int pEnd) {
        if (pEnd >= preorder.length || pStart > pEnd) return null;
        TreeNode result = new TreeNode(preorder[pStart]);
        int leftStart = pStart + 1;
        int leftEnd = pStart + 1;
        int pivotIdx = inorderMap.get(result.val);
        while(leftEnd < preorder.length && leftEnd <= pEnd) {
            if (inorderMap.get(preorder[leftEnd]) < pivotIdx) {
                leftEnd++;
            } else {
                break;
            }
        }
        leftEnd--;
        result.left = helper(preorder, inorderMap, leftStart, leftEnd);
        result.right = helper(preorder, inorderMap, leftEnd + 1, pEnd);
        return result;
    }
}
