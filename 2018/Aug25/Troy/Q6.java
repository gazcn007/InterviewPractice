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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.right == null && root.left == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode cur = root;
                Stack<TreeNode> stack = new Stack<>();
                while(stack.size() > 0 || cur != null) {
                    while(cur != null) {
                        stack.push(cur);
                        cur = cur.left;
                    }
                    cur = stack.pop();
                    if (cur.val > key) break;
                    cur = cur.right;
                }
                root.val = cur.val;
                root.right = deleteNode(root.right, cur.val);
            }
        } else if (root.val < key){
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }

        return root;
    }
}
