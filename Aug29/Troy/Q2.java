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
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        List<Integer> inorderList = new ArrayList<Integer>();
        for (int i : inorder)
        {
            inorderList.add(i);
        }
        List<Integer> postorderList = new ArrayList<Integer>();
        for (int i : postorder)
        {
            postorderList.add(i);
        }
        return helper(inorderList, postorderList, 0, inorder.length - 1);
    }

    public TreeNode helper(List<Integer> inorder, List<Integer> postorder, int pStart, int pEnd){
        if (pStart > pEnd || pStart < 0) return null;
        TreeNode result = new TreeNode(postorder.get(pEnd));
        if (pStart == pEnd) return result;
        int pivotIdx = inorder.indexOf(postorder.get(pEnd));
        int i = pEnd - 1;
        while(i >= pStart)
            if (inorder.indexOf(postorder.get(i)) > pivotIdx) {
                i--;
            } else {
                break;
            }
        }
        i = i + 1;
        result.right = helper(inorder, postorder, i, pEnd - 1);
        result.left = helper(inorder, postorder, pStart, i - 1);
        return result;
    }
    // inorder = [9,3,15,20,7]
    // postorder = [9,15,7,20,3]
}
