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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> visited = new HashSet<>();
        TreeNode cur = root;
        while(stack.size() > 0 || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.right == null || visited.contains(cur.right)) {
                result.add(cur.val);
                visited.add(cur);
                cur = null;
            } else if (!visited.contains(cur)){
                stack.add(cur);
                cur = cur.right;
            } else {
                cur = null;
            }
        }
        return result;
    }
}

class Solution {
    // Brilliant given solution, avoided the use of hashSet
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.empty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                result.addFirst(cur.val);    // Reverse the process of preorder
                cur = cur.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                cur = node.left;             // Reverse the process of preorder
            }
        }
        return result;
    }
}
