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
    // Truely messy code, off to play MW, should refine this
    // tommorow
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root != null) {
           stack.push(root);
            while(stack.size() > 0) {
                TreeNode cur = stack.pop();
                while(cur.left != null) {
                    TreeNode tmp = cur.left;
                    cur.left = null;
                    stack.push(cur);
                    cur = tmp;
                }

                while(cur.right != null) {
                    if (cur.right.left != null) {
                        stack.push(cur.right);
                        result.add(cur.val);
                        break;
                    } else {
                        result.add(cur.val);
                        cur = cur.right;
                    }
                }

                if (cur.right == null) result.add(cur.val);
            }
        }

        return result;
    }
}
